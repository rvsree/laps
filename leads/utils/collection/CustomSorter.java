package com.mortgage.leads.utils.collection;

import java.util.ArrayList;
import java.util.Collections;
import com.mortgage.leads.persistence.domain.Customer;

public class CustomSorter {

	ArrayList<Customer> customers = new ArrayList<Customer>();

	public CustomSorter(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public ArrayList<Customer> getSortedCustomerByAge() {
		Collections.sort(customers, Customer.ageComparator);
		return customers;
	}

	public ArrayList<Customer> getSortedCustomerByName() {
		Collections.sort(customers, Customer.nameComparator);
		return customers;
	}
}
