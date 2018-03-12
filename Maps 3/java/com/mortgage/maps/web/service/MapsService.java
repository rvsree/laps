package com.mortgage.maps.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mortgage.maps.persistence.domain.Customer;
import com.mortgage.maps.persistence.repository.MapsRepoistory;

@Service
public class MapsService {

	@Autowired
	MapsRepoistory mapsRepoistory;

	List<Customer> customers = new ArrayList<Customer>();

	public String pulse(String userName) {
		return mapsRepoistory.pulse(userName);
	}
	
	public Customer getCustomerById(String customerId) {
		return mapsRepoistory.getCustomerById(customerId);
	}

	public List<Customer> getCustomers() {
		return mapsRepoistory.getCustomers();
	}
	
	public Customer saveCustomer(Customer customer) {
		mapsRepoistory.saveCustomer(customer);
		return customer;
	}
	
	public List<Customer> updateCustomer(String customerId) {
		//return mapsRepoistory.updateCustomer(customerId);
		return null;
	}

	public List<Customer>  deleteCustomer(String customerId) {
		return mapsRepoistory.deleteCustomer(customerId);
	}
	
}
