package com.codespark.vitals.service;

import com.codespark.dto.user.UserProfileUpdateRequest;
import com.codespark.vitals.models.UserVitals;

import reactor.core.publisher.Mono;

public interface UserVitalsService {

    void updateUserVitals(UserProfileUpdateRequest updatedProfile);

    Mono<UserVitals> getUserVitals(Long userId);

}
