package com.laps.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.laps.customer.model.CustomerModel;
import com.laps.customer.repository.CustomerRepoistory;

@Service
public class CustomerService {

	@Autowired
	CustomerRepoistory customerRepoistory;

	public CustomerModel fetchCustomer() {

		return customerRepoistory.retrieveCustomer();
	}

}
