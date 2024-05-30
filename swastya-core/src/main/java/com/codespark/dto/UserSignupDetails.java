package com.codespark.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserSignupDetails {

    @NotNull(message = "Name cannot be empty.")
    @Size(min = 3, max = 30, message = "Name should be within 3 to 30 characters.")
    private String name;

    @NotNull(message = "Email cannot be empty.")
    @Email(message = "Email should be valid.")
    private String email;

}
