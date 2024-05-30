package com.codespark.auth.routes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codespark.auth.service.SignupService;
import com.codespark.dto.UserSignupDetails;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/signup")
public class SignupController {

    private final SignupService signupService;

    @PostMapping
    public Mono<ResponseEntity<String>> signupUser(@Valid @RequestBody final Mono<UserSignupDetails> signupDto) {
        return signupDto
                .map(dto -> signupService.signupUser(dto))
                .flatMap(user -> user);
    }

}
