package com.mortgage.maps.business.impl;

import org.springframework.stereotype.Component;
import com.mortgage.maps.business.interfaces.CreditHistory;;

@Component
public class CreditHistoryImpl implements CreditHistory {

	@Override
	public int getCreditScore(String customerId) {
		int creditScore = 0;

		if (customerId.substring(0, 1).equalsIgnoreCase("P")) {
			creditScore = 800;
		} else if (customerId.substring(0, 1).equalsIgnoreCase("G")) {
			creditScore = 740;
		} else if (customerId.substring(0, 1).equalsIgnoreCase("S")) {
			creditScore = 670;
		} else if (customerId.substring(0, 1).equalsIgnoreCase("B")) {
			creditScore = 580;
		} else {
			creditScore = 300;
		}
		
		return creditScore;
	}

}
