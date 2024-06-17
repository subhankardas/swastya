package com.codespark.vitals.routes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.codespark.core.dto.simple.ResponseCode;
import com.codespark.core.dto.simple.SimpleResponse;
import com.codespark.core.dto.user.UserSimpleResponse;
import com.codespark.core.exception.user.UserVitalsNotFoundException;

import reactor.core.publisher.Mono;

@ControllerAdvice
public class VitalsControllerAdvice {

    @ExceptionHandler(UserVitalsNotFoundException.class)
    public Mono<ResponseEntity<SimpleResponse>> handleUserVitalsNotFound(UserVitalsNotFoundException ex) {
        return Mono.just(new ResponseEntity<>(UserSimpleResponse.builder()
                .code(ResponseCode.USER_VITALS_NOT_FOUND)
                .message("User vitals not found!")
                .build(), HttpStatus.NOT_FOUND));
    }

}
