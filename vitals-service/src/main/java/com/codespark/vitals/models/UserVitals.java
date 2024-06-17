package com.codespark.vitals.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.codespark.core.dto.user.UserProfileUpdateRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Document(collection = "user_vitals")
public class UserVitals {

    @Id
    private Long userId;

    @Field("basic_vitals")
    private BasicVitals basicVitals;

    @Builder
    public UserVitals(UserProfileUpdateRequest profile) {
        this.userId = profile.getUserId();
        this.basicVitals = BasicVitals.builder().build();

        // Update basic vitals with updated profile
        this.basicVitals.updateBasicVitals(profile);
    }

}
