package com.laps.lending.repository;

import org.springframework.stereotype.Repository;

import com.laps.lending.model.AccountModel;

@Repository
public class AccountRepository {

	public AccountModel retrieveAccount(){
		
		AccountModel account = new AccountModel();
		
		account.setAccountId((long) 101);
		account.setAccountNumber("Test Account Number");
		account.setDefaultAccount(true);
		account.setUserId("ABC-123456");
		
		return account;		
	}
	
}
