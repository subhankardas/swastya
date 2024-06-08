package com.codespark.vitals.data;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.codespark.vitals.models.UserVitals;

public interface UserVitalsRepository extends ReactiveMongoRepository<UserVitals, Long> {

}
