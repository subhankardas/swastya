package com.codespark.vitals.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.codespark.core.dto.user.UserProfileUpdateRequest;
import com.codespark.core.dto.vitals.UserVitalsResponse;
import com.codespark.core.exception.user.UserVitalsNotFoundException;
import com.codespark.vitals.data.UserVitalsRepository;
import com.codespark.vitals.models.UserVitals;
import com.codespark.vitals.service.UserVitalsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserVitalsServiceImpl implements UserVitalsService {

    private final ModelMapper mapper;
    private final UserVitalsRepository userVitalsRepository;

    @Async
    @Override
    public void updateUserVitals(UserProfileUpdateRequest updatedProfile) {
        UserVitals userVitals = UserVitals.builder().profile(updatedProfile).build();
        userVitalsRepository.save(userVitals)
                .doOnSuccess(savedVitals -> {
                    log.info("Updated vitals for user ID: {}", savedVitals.getUserId());
                })
                .doOnError(ex -> {
                    log.error("Failed to update vitals for user ID: {}", updatedProfile.getUserId(), ex);
                }).subscribe();
    }

    @Override
    public Mono<UserVitalsResponse> getUserVitals(Long userId) {
        return userVitalsRepository.findById(userId)
                .map(userVitals -> mapper.map(userVitals, UserVitalsResponse.class))
                .switchIfEmpty(Mono.defer(() -> {
                    // User vitals not found, throw exception
                    log.error("Vitals not found for user ID: {}", userId);
                    return Mono.error(new UserVitalsNotFoundException());
                }));
    }

}
