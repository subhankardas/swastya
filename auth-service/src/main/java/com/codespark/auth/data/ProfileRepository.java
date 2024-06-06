package com.codespark.auth.data;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.codespark.auth.models.Profile;

import reactor.core.publisher.Mono;

public interface ProfileRepository extends R2dbcRepository<Profile, Long> {

    @Query("SELECT * FROM profiles WHERE user_id = :userId")
    Mono<Profile> findByUserId(Long userId);

}
