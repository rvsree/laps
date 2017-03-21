package com.laps.lending.model;

import java.io.Serializable;

public class AccountModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long accountId;
    private String userId;
    private String accountNumber;
    private Boolean defaultAccount;
    
	public Long getAccountId() {
		return accountId;
	}
	
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public Boolean getDefaultAccount() {
		return defaultAccount;
	}
	
	public void setDefaultAccount(Boolean defaultAccount) {
		this.defaultAccount = defaultAccount;
	}

}
