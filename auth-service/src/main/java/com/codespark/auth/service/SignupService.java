package com.codespark.auth.service;

import com.codespark.dto.user.UserSignupRequest;
import com.codespark.dto.user.UserSimpleResponse;

import reactor.core.publisher.Mono;

public interface SignupService {

        Mono<UserSimpleResponse> signupUser(UserSignupRequest dto);

}
