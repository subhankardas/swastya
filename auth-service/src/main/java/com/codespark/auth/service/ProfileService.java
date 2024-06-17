package com.codespark.auth.service;

import com.codespark.core.dto.user.UserProfileUpdateRequest;
import com.codespark.core.dto.user.UserSimpleResponse;

import reactor.core.publisher.Mono;

public interface ProfileService {

    Mono<UserSimpleResponse> updateUserProfile(Long userId, UserProfileUpdateRequest dto);

    Mono<UserProfileUpdateRequest> getUserProfile(Long userId);

}
