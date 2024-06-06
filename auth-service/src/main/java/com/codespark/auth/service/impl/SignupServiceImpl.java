package com.codespark.auth.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.codespark.auth.data.UserRepository;
import com.codespark.auth.models.User;
import com.codespark.auth.service.SignupService;
import com.codespark.dto.simple.ResponseCode;
import com.codespark.dto.user.UserSignupRequest;
import com.codespark.dto.user.UserSimpleResponse;
import com.codespark.exception.user.UserAlreadyExistsException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Service
public class SignupServiceImpl implements SignupService {

    private final ModelMapper mapper;
    private final UserRepository userRepository;

    public Mono<UserSimpleResponse> signupUser(UserSignupRequest signupDto) {
        User user = mapper.map(signupDto, User.class);
        return userRepository
                .findByEmail(user.getEmail())
                .flatMap(existingUser -> {
                    if (existingUser == null) {
                        return signupNewUser(user);
                    }

                    // User already exists, throw exception
                    log.error("User already exists with email: {}", existingUser.getEmail());
                    return Mono.error(new UserAlreadyExistsException());
                })
                .switchIfEmpty(Mono.defer(() -> {
                    return signupNewUser(user);
                }));
    }

    /** Signup new user. */
    private Mono<UserSimpleResponse> signupNewUser(User user) {
        log.info("Signing up new user: {}", user.getName());
        return userRepository.save(user)
                .map(newUser -> {
                    return UserSimpleResponse.builder()
                            .code(ResponseCode.USER_SIGNUP_SUCCESS)
                            .message("User signup successful!")
                            .userId(newUser.getId())
                            .build();
                });
    }

}
