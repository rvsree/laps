package com.mortgage.leads.web.security;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserAccountData implements CommandLineRunner {

	@Autowired
	private UserAccountRepository userAccountRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		
		Stream
			.of("admin, admin", "analyst, analyst", "manager, manager")
			.map(credential -> credential.split(","))
			.forEach(tuple -> userAccountRepository.save(new UserAccount(tuple[0], tuple[1], true)));
		
	}

}
