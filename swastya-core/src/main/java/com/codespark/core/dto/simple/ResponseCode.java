package com.codespark.core.dto.simple;

public enum ResponseCode {

    VALIDATION_ERROR,

    // User login/signup codes
    USER_SIGNUP_SUCCESS,
    USER_SIGNUP_FAILED,

    // User profile codes
    USER_NOT_FOUND,

    USER_PROFILE_CREATED,
    USER_PROFILE_UPDATED,
    USER_PROFILE_NOT_FOUND,

    // User vitals codes
    USER_VITALS_NOT_FOUND,

}
