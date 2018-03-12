package com.mortgage.maps.utils.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import com.mortgage.maps.business.impl.CreditHistoryImpl;
import com.mortgage.maps.business.impl.CreditSupplementImpl;
import com.mortgage.maps.business.impl.UnderwrittingImpl;
import com.mortgage.maps.business.impl.ValuationImpl;
import com.mortgage.maps.business.interfaces.CreditHistory;
import com.mortgage.maps.business.interfaces.CreditSupplement;
import com.mortgage.maps.business.interfaces.Underwritting;
import com.mortgage.maps.business.interfaces.Valuation;
import com.mortgage.maps.persistence.domain.Customer;
import com.mortgage.maps.persistence.domain.Lead;
import com.mortgage.maps.business.core.PrimaryMortgageLoan;
import com.mortgage.maps.business.core.RefinanceMortgageLoan;
import com.mortgage.maps.business.core.SecondaryMortgageLoan;

@Configuration
@ComponentScan()
@EnableAspectJAutoProxy
@Import(AppConfig.class)
public class MapsConfig {

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
	public PrimaryMortgageLoan primaryMortgageLoan() {
		return new PrimaryMortgageLoan();
	}

	@Bean
	public SecondaryMortgageLoan secondaryMortgageLoan() {
		return new SecondaryMortgageLoan();
	}

	@Bean
	public RefinanceMortgageLoan refinanceMortgageLoan() {
		return new RefinanceMortgageLoan();
	}

	@Bean
	public CreditHistory creditHistory() {
		return new CreditHistoryImpl();
	}

	@Bean
	public Underwritting underwritting() {
		return new UnderwrittingImpl();
	}

	@Bean
	public Valuation valuation() {
		return new ValuationImpl();
	}
	
	@Bean
	public CreditSupplement creditSupplement() {
		return new CreditSupplementImpl();
	}

	@Bean
	public Lead lead() {
		return new Lead();
	}
}
