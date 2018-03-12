package com.mortgage.leads.persistence.dao;

import java.util.List;

import com.mortgage.leads.persistence.domain.Customer;
import com.mortgage.leads.persistence.domain.Lead;
import com.mortgage.leads.utils.exception.DAOException;

public interface CustomerDAO {
	
	Customer getLeadById(String sqlCustomer, String Id);
	List<Customer> getLeads(String sqlCustomer) ;
	Lead getLeadStatus(String sqlLead, String Id);
	void saveLead(Customer customer) throws DAOException;

}
