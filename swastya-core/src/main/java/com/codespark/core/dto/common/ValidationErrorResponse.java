package com.codespark.core.dto.common;

import java.util.Map;

import com.codespark.core.dto.simple.ResponseCode;
import com.codespark.core.dto.simple.SimpleResponse;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ValidationErrorResponse extends SimpleResponse {

    private Map<String, String> errors;

    public ValidationErrorResponse(Map<String, String> errors) {
        super(ResponseCode.VALIDATION_ERROR, "Validation failed!");
        this.errors = errors;
    }

}
