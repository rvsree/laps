package com.mortgage.maps.business.impl;

import org.springframework.stereotype.Component;
import com.mortgage.maps.business.interfaces.CreditSupplement;

@Component
public class CreditSupplementImpl implements CreditSupplement {

	@Override
	public boolean getCreditSupplementStatus(int creditScore) {
		boolean creditSupplementStatus = false;

		if (creditScore == 800 || creditScore == 740 || creditScore == 670) {
			creditSupplementStatus = true;
		} else if (creditScore == 580 || creditScore == 300 ) {
			creditSupplementStatus = false;
		} 
		
		return creditSupplementStatus;
	}

}
