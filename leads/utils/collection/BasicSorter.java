package com.mortgage.leads.utils.collection;

import java.util.ArrayList;
import java.util.Collections;
import com.mortgage.leads.persistence.domain.Customer;

public class BasicSorter{

	private ArrayList<Customer> customers;

	public BasicSorter(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public ArrayList<Customer> getArrayList() {
		return this.customers;
	}

	public ArrayList<Customer> sortAscending() {
		Collections.sort(this.customers);
		return this.customers;
	}

	public ArrayList<Customer> sortDescending() {
		Collections.sort(this.customers, Collections.reverseOrder());
		return this.customers;
	}

}
