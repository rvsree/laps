package com.mortgage.leads.utils.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CopyOnWriteArrayList;
import com.mortgage.leads.persistence.domain.Customer;

public class CustomerDTO {
	
	static List<Customer> cachedCustomers = new ArrayList<Customer>();

	public static List<Customer> getSortedCustomers(List<Customer> customers, String sortType) {

		hashMapCustomers(customers);
		
		ArrayList<Customer> sortedCustomers = null;
		ArrayList<Customer> unsortedCustomers = new ArrayList<Customer>(modifyCustomerList(customers));
		CustomSorter customSorter = new CustomSorter((ArrayList<Customer>) unsortedCustomers);
		
		if (sortType.equalsIgnoreCase("custom")) {
			sortedCustomers = customSorter.getSortedCustomerByName();
		} else if (sortType.equalsIgnoreCase("basic")) {
			BasicSorter basicSorter = new BasicSorter((ArrayList<Customer>) unsortedCustomers);
			sortedCustomers = basicSorter.sortDescending();
		}

		cachedCustomers = sortedCustomers;
		return sortedCustomers;
		
	}
	
	private static List<Customer> modifyCustomerList(List<Customer> unsortedCustomers) {
		List<Customer> modifiedCustomers = new CopyOnWriteArrayList<>(unsortedCustomers);
		Iterator<Customer> customerIterator = modifiedCustomers.iterator();
		
		while (customerIterator.hasNext()) {
			Customer customer = customerIterator.next();
			if (customer.getFirstName().equalsIgnoreCase("Balaji")) {
				//System.out.println("removing modifyCustomerList: " + customer.getFirstName());				
				modifiedCustomers.remove(customer);
			}
			else {
				//System.out.println("modifyCustomerList : " + customer);
			}
		}
		return modifiedCustomers;
	}
	
	private static void hashMapCustomers(List<Customer> customers) {
		
		Map<String, Customer> mapCustomers = new HashMap<>();
		int index = 1;
		for (Customer customer : customers) {
			mapCustomers.put(customer.getCustomerId() + "(" + index + ")", customer);
			index ++;
		}
		
		for (Map.Entry<String, Customer> entry : mapCustomers.entrySet()) {
		    System.out.println(entry.getKey() + " :: " + entry.getValue());
		}
	}
	
}
