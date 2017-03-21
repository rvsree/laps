package com.laps.dashboard;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@SpringBootApplication
@RestController
@EnableHystrix
@EnableHystrixDashboard
public class ApiDashboardApplication {

	@Autowired
	private RestTemplate restTempalte;

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	@RequestMapping("/startSample")
	@HystrixCommand(fallbackMethod="failOver", commandProperties={
			@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="500")
	})
	public String startSample(@RequestParam long timeout) throws InterruptedException{ 
		
			System.out.println("timeout : " + timeout);
		
			if (timeout > 0 )
				Thread.sleep(timeout);
			
			URI uriCustomer = URI.create("http://localhost:9032/sample");
			return restTempalte.getForObject(uriCustomer, String.class);
	}
	
	public String failOver(long timeout) {
		return "transaction failed, redirected to fail over method " + timeout;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ApiDashboardApplication.class, args);
	}
}
