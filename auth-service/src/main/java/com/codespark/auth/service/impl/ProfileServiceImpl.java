package com.codespark.auth.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.codespark.auth.data.ProfileRepository;
import com.codespark.auth.data.UserRepository;
import com.codespark.auth.models.Profile;
import com.codespark.auth.models.User;
import com.codespark.auth.service.EventService;
import com.codespark.auth.service.ProfileService;
import com.codespark.core.constants.ActivityLevel;
import com.codespark.core.constants.Gender;
import com.codespark.core.dto.simple.ResponseCode;
import com.codespark.core.dto.user.UserProfileUpdateRequest;
import com.codespark.core.dto.user.UserSimpleResponse;
import com.codespark.core.exception.user.UserNotFoundException;
import com.codespark.core.exception.user.UserProfileNotFoundException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProfileServiceImpl implements ProfileService {

    private final ModelMapper mapper;

    private final EventService eventService;

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    public Mono<UserSimpleResponse> updateUserProfile(Long userId, UserProfileUpdateRequest dto) {
        return userRepository.findById(userId)
                .flatMap(user -> {
                    // User found, update user profile
                    Profile profile = mapper.map(dto, Profile.class);
                    return updateUserProfile(user, profile);
                })
                .switchIfEmpty(Mono.defer(() -> {
                    // User not found, throw exception
                    log.error("User not found by ID: {}", userId);
                    return Mono.error(new UserNotFoundException());
                }));
    }

    /** Update user profile if it exists. Create profile for new user. */
    private Mono<UserSimpleResponse> updateUserProfile(User user, Profile profile) {
        return profileRepository.findByUserId(user.getId())
                .flatMap(existingProfile -> {
                    // Update existing profile
                    log.debug("Updating existing profile for user ID: {}", user.getId());
                    return updateExistingUserProfile(user.getId(), existingProfile.getId(), profile)
                            .map(updatedProfile -> publishUserProfileUpdate(user.getId(), profile))
                            .map(updatedProfile -> UserSimpleResponse
                                    .builder()
                                    .code(ResponseCode.USER_PROFILE_UPDATED)
                                    .message("Profile updated successfully!")
                                    .userId(updatedProfile.getUserId())
                                    .build());
                })
                .switchIfEmpty(Mono.defer(() -> {
                    // Create new profile
                    log.debug("Creating new profile for user ID: {}", user.getId());
                    return createNewProfile(user, profile)
                            .map(newProfile -> publishUserProfileUpdate(user.getId(), profile))
                            .map(newProfile -> UserSimpleResponse
                                    .builder()
                                    .code(ResponseCode.USER_PROFILE_CREATED)
                                    .message("Profile created successfully!")
                                    .userId(newProfile.getUserId())
                                    .build());
                }));
    }

    /** Update existing user profile. */
    private Mono<Profile> updateExistingUserProfile(Long userId, Long profileId, Profile profile) {
        profile.setId(profileId);
        profile.setUserId(userId);
        return profileRepository.save(profile);
    }

    /** Create new user profile. */
    private Mono<Profile> createNewProfile(User user, Profile profile) {
        profile.setUserId(user.getId());
        return profileRepository.save(profile);
    }

    /** Publish user profile update event. */
    private Profile publishUserProfileUpdate(Long userId, Profile profile) {
        // Set profile update event data
        UserProfileUpdateRequest data = mapper.map(profile, UserProfileUpdateRequest.class);
        data.setActivity(ActivityLevel.fromActivity(profile.getActivity()));
        data.setGender(Gender.fromGender(profile.getGender()));

        eventService.publish("profile.update", Long.toString(userId), data);
        return profile;
    }

    @Override
    public Mono<UserProfileUpdateRequest> getUserProfile(Long userId) {
        return profileRepository.findByUserId(userId)
                .map(profile -> {
                    // Map profile data
                    UserProfileUpdateRequest dto = mapper.map(profile, UserProfileUpdateRequest.class);
                    dto.setActivity(ActivityLevel.fromActivity(profile.getActivity()));
                    dto.setGender(Gender.fromGender(profile.getGender()));

                    return dto;
                })
                .switchIfEmpty(Mono.defer(() -> {
                    // User not found, throw exception
                    log.error("Profile not found for user ID: {}", userId);
                    return Mono.error(new UserProfileNotFoundException());
                }));
    }

}
