package com.mortgage.maps.persistence.repository;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import com.mortgage.maps.business.core.PrimaryMortgageLoan;
import com.mortgage.maps.business.core.RefinanceMortgageLoan;
import com.mortgage.maps.business.core.SecondaryMortgageLoan;
import com.mortgage.maps.persistence.helper.MapsDAO;
import com.mortgage.maps.utils.config.AppConfig;
import com.mortgage.maps.utils.config.MapsConfig;
import com.mortgage.maps.utils.exception.DAOException;
import com.mortgage.maps.persistence.domain.Customer;
import com.mortgage.maps.persistence.domain.Lead;

@Repository
public class MapsRepoistory {

	@Resource
	MapsConfig mortgageConfig;
	
	@Autowired
	AppConfig appConfig;

	/*
	 * @Autowired @Qualifier("primaryMortgageLoan") MortgageLoan pmLoan;
	 */

	@Autowired
	Lead lead;

	@Autowired
	MapsDAO customerDAO;
	@Autowired
	List<Customer> customers; // = new CopyOnWriteArrayList<Customer>();

	ApplicationContext appContext;
	ApplicationContext xmlContext;
	PrimaryMortgageLoan primaryMortgageLoan;
	SecondaryMortgageLoan secondaryMortgageLoan;
	RefinanceMortgageLoan refinanceMortgageLoan;

	public MapsRepoistory() {
		appContext = new AnnotationConfigApplicationContext(MapsConfig.class);
		xmlContext = new ClassPathXmlApplicationContext("xmlconfig/MapsAppContext.xml");

		primaryMortgageLoan = appContext.getBean("primaryMortgageLoan", PrimaryMortgageLoan.class);
		// secondaryMortgageLoan = appContext.getBean("secondaryMortgageLoan", SecondaryMortgageLoan.class);
		refinanceMortgageLoan = appContext.getBean("refinanceMortgageLoan", RefinanceMortgageLoan.class);

		/* System.out.println("bean count: " + appContext.getBeanDefinitionCount());
		 * 
		 * for (String beanName : appContext.getBeanDefinitionNames()) {
		 * System.out.println("\n bean name: " + beanName); } */
	}

	public String pulse(String userName) {
		String activeEnviron = appConfig.getActiveEnviron();
		return "activeEnviron: " + activeEnviron;
	}

	public Customer getCustomerById(String customerId) {
		return null;	//customers.stream().filter(c -> c.getCustomerId().equalsIgnoreCase(customerId)).findFirst().get();
	}
	
	public List<Customer> getCustomers() {
		return null;
	}
	
	public List<Customer> saveCustomer( Customer customer) {

		customers.add(customer);
		try {
			customerDAO.saveCustomer(customer);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return customers;
	}
	
	public List<Customer> deleteCustomer(String customerId) {
		customers.stream().filter(customer -> customer.getCustomerId().equalsIgnoreCase(customerId)).findFirst()
				.map(c -> {
					customers.remove(c);
					return c;
				});

		return customers;
	}

}
