package com.codespark.core.dto.vitals;

import lombok.Data;

@Data
public class UserVitalsResponse {

    private Long userId;
    private BasicVitals basicVitals;

}
