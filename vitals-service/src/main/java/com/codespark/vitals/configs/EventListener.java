package com.codespark.vitals.configs;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.codespark.dto.user.UserProfileUpdateRequest;
import com.codespark.vitals.data.UserVitalsRepository;
import com.codespark.vitals.models.UserVitals;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class EventListener {

    private static final String GROUP_ID = "vitals-service";

    private final UserVitalsRepository userVitalsRepository;

    @KafkaListener(groupId = GROUP_ID, topics = "profile.update")
    public void handleProfileUpdateEvent(UserProfileUpdateRequest updatedProfile) {
        log.info("Received: {}", updatedProfile);

        UserVitals userVitals = new UserVitals();
        userVitals.setUserId(updatedProfile.getUserId());
        userVitals.setBmi(123);
        Mono<UserVitals> re = userVitalsRepository.save(userVitals);
        re.subscribe(data -> {
            System.out.println("data: " + data);
        });
    }

}
