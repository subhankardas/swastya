package com.codespark.vitals.routes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codespark.core.dto.vitals.UserVitalsResponse;
import com.codespark.vitals.service.UserVitalsService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("vitals/{userId}")
public class UserVitalsController {

    private final UserVitalsService userVitalsService;

    @GetMapping
    public Mono<UserVitalsResponse> getUserVitals(@PathVariable Long userId) {
        return userVitalsService.getUserVitals(userId);
    }

}
