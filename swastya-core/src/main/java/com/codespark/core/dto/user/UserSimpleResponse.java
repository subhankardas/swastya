package com.codespark.core.dto.user;

import com.codespark.core.dto.simple.ResponseCode;
import com.codespark.core.dto.simple.SimpleResponse;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserSimpleResponse extends SimpleResponse {

    private Long userId;

    @Builder
    public UserSimpleResponse(ResponseCode code, String message, Long userId) {
        super(code, message);
        this.userId = userId;
    }

}
