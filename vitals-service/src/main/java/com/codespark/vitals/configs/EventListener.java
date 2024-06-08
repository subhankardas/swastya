package com.codespark.vitals.configs;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.codespark.dto.user.UserProfileUpdateRequest;
import com.codespark.vitals.service.UserVitalsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class EventListener {

    private static final String GROUP_ID = "vitals-service";

    private final UserVitalsService userVitalsService;

    @KafkaListener(groupId = GROUP_ID, topics = "profile.update")
    public void handleUserProfileUpdateEvent(UserProfileUpdateRequest updatedProfile) {
        log.debug("User profile updated for user ID: {}", updatedProfile.getUserId());
        userVitalsService.updateUserVitals(updatedProfile);
    }

}
