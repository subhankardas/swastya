package com.codespark.auth.service;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codespark.auth.data.UserRepository;
import com.codespark.auth.models.User;
import com.codespark.dto.UserSignupDetails;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Service
public class SignupService {

    private final ModelMapper mapper;
    private final UserRepository userRepository;

    public Mono<ResponseEntity<String>> signupUser(UserSignupDetails signupDto) {
        User user = mapper.map(signupDto, User.class);
        return userRepository
                .findByEmail(user.getEmail())
                .flatMap(existingUser -> {
                    log.warn("User already exists with email: {}", user.getEmail());
                    return Mono.just(new ResponseEntity<>("User already exists", HttpStatus.CONFLICT));
                })
                .switchIfEmpty(Mono.defer(() -> {
                    log.info("Signing up new user: {}", user.getName());
                    return userRepository.save(user)
                            .map(user1 -> new ResponseEntity<>("User created successfully", HttpStatus.CREATED));
                }));
    }

}
