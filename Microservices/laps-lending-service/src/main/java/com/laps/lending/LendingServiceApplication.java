package com.laps.lending;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LendingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LendingServiceApplication.class, args);
	}
}
