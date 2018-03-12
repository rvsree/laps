package com.mortgage.maps.persistence.helper;

import java.util.List;

import com.mortgage.maps.persistence.domain.Customer;
import com.mortgage.maps.persistence.domain.Lead;
import com.mortgage.maps.utils.exception.DAOException;

public interface MapsDAO {
	
	Customer getCustomerById(String sqlCustomer, String Id);
	List<Customer> getAllCustomers(String sqlCustomer) ;
	Lead getLeadStatus(String sqlLead, String Id);
	void saveCustomer(Customer customer) throws DAOException;

}
