package com.laps.customer.repository;

import org.springframework.stereotype.Repository;
import com.laps.customer.model.CustomerModel;

@Repository
public class CustomerRepoistory {

	public CustomerModel retrieveCustomer(){
		
		CustomerModel customer = new CustomerModel();
		
		customer.setCustomerId(9001);
		customer.setFirstName("ABC-123");
		customer.setFirstName("XYZ-123");
		customer.setAccountType("Savings");
		
		return customer;		
	}
}
