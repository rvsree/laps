package com.mortgage.mapsgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class MapsGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapsGatewayApplication.class, args);
	}
	
	
}
