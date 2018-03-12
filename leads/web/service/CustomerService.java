package com.mortgage.leads.web.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mortgage.leads.persistence.domain.Customer;
import com.mortgage.leads.persistence.repository.CustomerRepoistory;
import com.mortgage.leads.utils.collection.CustomerDTO;
import com.mortgage.leads.utils.exception.LeadsException;
import com.mortgage.leads.utils.threading.CorporateActions;
import com.mortgage.leads.utils.threading.CorporateActionsGEN;
import com.mortgage.leads.utils.threading.CorporateActionsIPB;
import com.mortgage.leads.utils.threading.CorporateActionsPBA;

@Service @Transactional
public class CustomerService  {

	@Autowired
	CustomerRepoistory customerRepoistory;
	
	@Autowired 
	CorporateActionsIPB corpActionsIPB;
	
	@Autowired
	CorporateActionsPBA corpActionsPBA;
	
	@Autowired
	CorporateActionsGEN corpActionsGEN;
	

	//@Transactional(readOnly = false)
	public Customer getLeadById(String customerId) {
		return customerRepoistory.getLeadById(customerId);
	}

	//@Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
	public List<Customer> getLeads() {
		return customerRepoistory.getLeads();
	}
	
	public List<Customer> saveLead(List<Customer> customers) {
		
		//multi-threaded notification requests
		this.sendNotification(customers.size());
		
		List<Customer> sortedCustomers = null;
		String sortType = "basic";
		
		try {
			sortedCustomers = CustomerDTO.getSortedCustomers(customers, sortType);
			for (Customer sortedCustomer : sortedCustomers) {
				customerRepoistory.saveLead(sortedCustomer);
			}
		} catch(Exception ex) {
		  System.err.println("Error in Customer-Service layer: " + ex.getMessage());
		}
		return sortedCustomers;
	}

	public List<Customer> updateCustomer(String customerId, Customer customer) {
		return customerRepoistory.updateLead(customerId);
	}
	
	public List<Customer> deleteCustomer(String customerId) {
		return customerRepoistory.deleteLead(customerId);
	}
	
	private void sendNotification(int count) {
		//this.ipbNotification(count);
		//this.pbaNotification(count);
		this.genNotification(count);
	}

	private void ipbNotification(int count) {
		try {
			System.out.println("before calling processIPBRequest");
			corpActionsIPB.processNotifcationRequest(count);
			System.out.println("after calling processIPBRequest");			
		} catch (LeadsException e) {
			e.printStackTrace();
		}
	}
	
	private void pbaNotification(int count) {
		try {
			System.out.println("before calling processPBARequest");
			corpActionsPBA.processNotifcationRequest(count);
			System.out.println("after calling processPBARequest");			
		} catch (LeadsException e) {
			e.printStackTrace();
		}
	}
	
	private void genNotification(int count) {
		try {
			System.out.println("before calling processGENRequest");
			corpActionsGEN.processNotifcationRequest(count);
			System.out.println("after calling processGENRequest");			
		} catch (LeadsException e) {
			e.printStackTrace();
		}
	}
}	
