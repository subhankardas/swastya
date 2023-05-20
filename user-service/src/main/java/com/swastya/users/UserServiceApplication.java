package com.swastya.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}

@RestController
class UserController {

	@GetMapping("/v1/users")
	public String usersV1() {
		return "users v1";
	}

	@GetMapping("/v2/users")
	public String usersV2() {
		return "users v2";
	}

}