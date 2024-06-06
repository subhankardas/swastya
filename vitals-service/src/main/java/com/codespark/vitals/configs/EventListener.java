package com.codespark.vitals.configs;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.codespark.dto.user.UserProfileUpdateRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class EventListener {

    private static final String GROUP_ID = "vitals-service";

    @KafkaListener(groupId = GROUP_ID, topics = "profile.update")
    public void handleProfileUpdateEvent(UserProfileUpdateRequest updatedProfile) {
        log.info("Received: {}", updatedProfile);
    }

}
