package com.mortgage.maps.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mortgage.maps.business.interfaces.CreditHistory;
import com.mortgage.maps.business.interfaces.Underwritting;
import com.mortgage.maps.business.interfaces.Valuation;

@Component
public class ValuationImpl implements Valuation {

	@Autowired
	private CreditHistory creditHistory;
	
	@Autowired
	private Underwritting underwritting;
	
	@Override
	public int getCreditStatus(String customerId) {
		return creditHistory.getCreditScore(customerId);
	}

	@Override
	public String getUnderwrittingStatus(int creditScore) {
		return underwritting.getUnderwrittingStatus(creditScore);
	}

}
