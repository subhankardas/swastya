package com.codespark.auth.models;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("profiles")
public class Profile {

    @Id
    private Long id;
    private LocalDate dateOfBirth;
    private Float height;
    private Float weight;

    private Long userId;

}
