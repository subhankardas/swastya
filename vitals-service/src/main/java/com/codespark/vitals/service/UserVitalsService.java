package com.codespark.vitals.service;

import com.codespark.core.dto.user.UserProfileUpdateRequest;
import com.codespark.core.dto.vitals.UserVitalsResponse;

import reactor.core.publisher.Mono;

public interface UserVitalsService {

    void updateUserVitals(UserProfileUpdateRequest updatedProfile);

    Mono<UserVitalsResponse> getUserVitals(Long userId);

}
