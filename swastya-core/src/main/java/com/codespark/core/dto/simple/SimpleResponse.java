package com.codespark.core.dto.simple;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SimpleResponse {

    private ResponseCode code;
    private String message;

}
