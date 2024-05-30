package com.codespark.auth.data;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.codespark.auth.models.User;

import reactor.core.publisher.Mono;

public interface UserRepository extends R2dbcRepository<User, Integer> {

    Mono<User> findByEmail(String email);

}
