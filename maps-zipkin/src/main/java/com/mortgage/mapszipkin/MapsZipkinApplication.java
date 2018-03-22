package com.mortgage.mapszipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class MapsZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapsZipkinApplication.class, args);
	}
}
