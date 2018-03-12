package com.mortgage.maps.business.interfaces;

public interface Valuation {

	int getCreditStatus(String customerId);
	String getUnderwrittingStatus(int creditScore);
	
}
