package com.mortgage.leads.persistence.repository;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mortgage.leads.persistence.dao.CustomerDAO;
import com.mortgage.leads.persistence.domain.Customer;
import com.mortgage.leads.utils.exception.DAOException;

//@Transactional
@Repository
public class CustomerRepoistory {

	@Autowired
	CustomerDAO customerDAO;
	
	List<Customer> customers = new ArrayList<Customer>();

	public CustomerRepoistory() { }

	public CustomerRepoistory(Customer customer) {
		customers.add(customer);
	}
	
	public List<Customer> getLeads() {
		return customers;
	}

	public Customer getLeadById(String customerId) {
		return customers.stream().filter(c -> c.getCustomerId().equalsIgnoreCase(customerId)).findFirst().get();
	}

	public Customer saveLead(Customer customer) throws DAOException {

		customers.add(customer);
		try {
			customerDAO.saveLead(customer);
		} catch (DAOException ex) {
		  	System.err.println("Error in Customer-DAO layer: " + ex.getMessage());
		  	throw new DAOException("ssf" + ex);
		}
		return customer;
	}
	
	public List<Customer> updateLead(String customerId) {
		customers.stream().filter(customer -> customer.getCustomerId().equalsIgnoreCase(customerId)).findFirst()
				.map(c -> {
					customers.remove(c);
					return c;
				});

		return customers;
	}

	public List<Customer> deleteLead(String customerId) {
		customers.stream().filter(customer -> customer.getCustomerId().equalsIgnoreCase(customerId)).findFirst()
				.map(c -> {
					customers.remove(c);
					return c;
				});

		return customers;
	}
}
