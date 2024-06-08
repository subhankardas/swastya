package com.codespark.vitals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class VitalsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VitalsServiceApplication.class, args);
	}

}
