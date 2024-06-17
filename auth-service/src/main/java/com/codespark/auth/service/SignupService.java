package com.codespark.auth.service;

import com.codespark.core.dto.user.UserSignupRequest;
import com.codespark.core.dto.user.UserSimpleResponse;

import reactor.core.publisher.Mono;

public interface SignupService {

        Mono<UserSimpleResponse> signupUser(UserSignupRequest dto);

}
