package com.laps.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.laps.customer.model.CustomerModel;
import com.laps.customer.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/customer")
	public CustomerModel getCustomer(){ 

		return customerService.fetchCustomer();
	}
	
	@RequestMapping("/sample")
	public String sample(){ 

		String response = "Hystrix test response.";
		return response;
	}
	
}
