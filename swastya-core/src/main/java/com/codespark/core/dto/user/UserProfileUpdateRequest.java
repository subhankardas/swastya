package com.codespark.core.dto.user;

import java.io.Serializable;
import java.time.LocalDate;

import com.codespark.core.constants.ActivityLevel;
import com.codespark.core.constants.Gender;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileUpdateRequest implements Serializable {

    @Past(message = "Date of birth should be a past date.")
    private LocalDate dateOfBirth;

    @Positive(message = "Height should be a positive value.")
    private Float height;

    @Positive(message = "Weight should be a positive value.")
    private Float weight;

    private ActivityLevel activity;
    private Gender gender;
    private Long userId;

}
