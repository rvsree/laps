package com.laps.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.laps.customer.model.CustomerModel;
import com.laps.customer.service.CustomerAsyncService;
import com.laps.customer.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@Autowired
	CustomerAsyncService customerAsyncService;

	@RequestMapping("/customer")
	public CustomerModel getCustomer() {

		return customerService.fetchCustomer();
	}

	@RequestMapping("/customerasync")
	public CustomerModel getCustomerAsync() {
		long time = System.currentTimeMillis();

		// Call Async service
		CustomerModel customerModel = customerAsyncService.fetchCustomer();

		String response = String.format("Response completed in %d milliseconds.", (System.currentTimeMillis() - time));
		// you should see this message before the message in the async method
		System.out.println(response);

		return customerModel;
	}

	@RequestMapping("/sample")
	public String sample() {

		String response = "Hystrix test response.";
		return response;
	}
}
