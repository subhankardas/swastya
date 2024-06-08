package com.codespark.vitals.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "user_vitals")
public class UserVitals {

    @Id
    private Long userId;
    private Integer bmi;

}
