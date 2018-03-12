package com.mortgage.leads.utils.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

import com.mortgage.leads.persistence.domain.Customer;
import com.mortgage.leads.persistence.domain.Lead;
import com.mortgage.leads.utils.threading.CorporateActionsGEN;
import com.mortgage.leads.utils.threading.CorporateActionsIPB;
import com.mortgage.leads.utils.threading.CorporateActionsPBA;

@Configuration
@ComponentScan()
@EnableAspectJAutoProxy
@Import(AppConfig.class)
public class LeadsConfig { 

	@Bean
	public Customer customer() {
		return new Customer();
	}

	@Bean
	public List<Customer> customers() {
		List<Customer> customers = new ArrayList<Customer>();
		return customers;
	}

	@Bean
	public Lead lead() {
		return new Lead();
	}
	
	@Bean
	public CorporateActionsPBA corpActionsPBA() {
		return new CorporateActionsPBA();
	}
	
	@Bean
	public CorporateActionsIPB corpActionsIPB() {
		return new CorporateActionsIPB();
	}	
	
	@Bean
	public CorporateActionsGEN corpActionsGEN() {
		return new CorporateActionsGEN();
	}

	
}
