package com.codespark.auth.routes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codespark.auth.service.ProfileService;
import com.codespark.dto.simple.ResponseCode;
import com.codespark.dto.user.UserProfileUpdateRequest;
import com.codespark.dto.user.UserSimpleResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("users/{userId}/profile")
public class ProfileController {

    private final ProfileService profileService;

    @PutMapping
    public Mono<ResponseEntity<UserSimpleResponse>> updateUserProfile(@PathVariable Long userId,
            @Valid @RequestBody Mono<UserProfileUpdateRequest> profileUpdateDto) {
        return profileUpdateDto
                .map(dto -> profileService.updateUserProfile(userId, dto))
                .flatMap(profile -> profile)
                .map(profile -> {
                    if (profile.getCode() == ResponseCode.USER_PROFILE_UPDATED) {
                        return new ResponseEntity<>(profile, HttpStatus.OK);
                    } else if (profile.getCode() == ResponseCode.USER_PROFILE_CREATED) {
                        return new ResponseEntity<>(profile, HttpStatus.CREATED);
                    }
                    return new ResponseEntity<>(profile, HttpStatus.BAD_REQUEST);
                })
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @GetMapping
    public Mono<ResponseEntity<UserProfileUpdateRequest>> getUserProfile(@PathVariable Long userId) {
        return profileService.getUserProfile(userId)
                .map(profile -> new ResponseEntity<>(profile, HttpStatus.OK));
    }

}
