package com.laps.lending.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laps.lending.model.AccountModel;
import com.laps.lending.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	public AccountModel fetchAccount(){
		
		return accountRepository.retrieveAccount();
	}
}
