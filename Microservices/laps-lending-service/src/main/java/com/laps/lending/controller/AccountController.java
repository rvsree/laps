package com.laps.lending.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laps.lending.model.AccountModel;
import com.laps.lending.service.AccountService;


@RestController
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@RequestMapping("/account")
	public AccountModel getAccount(){ 

		return accountService.fetchAccount();
		
	}
}
