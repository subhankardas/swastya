package com.codespark.auth.routes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.codespark.core.dto.simple.ResponseCode;
import com.codespark.core.dto.simple.SimpleResponse;
import com.codespark.core.dto.user.UserSimpleResponse;
import com.codespark.core.exception.user.UserAlreadyExistsException;
import com.codespark.core.exception.user.UserNotFoundException;
import com.codespark.core.exception.user.UserProfileNotFoundException;

import reactor.core.publisher.Mono;

@ControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    public Mono<ResponseEntity<SimpleResponse>> handleUserNotFound(UserNotFoundException ex) {
        return Mono.just(new ResponseEntity<>(UserSimpleResponse.builder()
                .code(ResponseCode.USER_NOT_FOUND)
                .message("User not found!")
                .build(), HttpStatus.NOT_FOUND));
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public Mono<ResponseEntity<SimpleResponse>> handleUserAlreadyExists(UserAlreadyExistsException ex) {
        return Mono.just(new ResponseEntity<>(UserSimpleResponse.builder()
                .code(ResponseCode.USER_SIGNUP_FAILED)
                .message("User already exists!")
                .build(), HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(UserProfileNotFoundException.class)
    public Mono<ResponseEntity<SimpleResponse>> handleUserProfileNotFound(UserProfileNotFoundException ex) {
        return Mono.just(new ResponseEntity<>(UserSimpleResponse.builder()
                .code(ResponseCode.USER_PROFILE_NOT_FOUND)
                .message("User profile not found!")
                .build(), HttpStatus.BAD_REQUEST));
    }

}
