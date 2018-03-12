package com.mortgage.maps.business.impl;

import org.springframework.stereotype.Component;

import com.mortgage.maps.business.interfaces.Underwritting;

@Component
public class UnderwrittingImpl implements Underwritting {

	@Override
	public String getUnderwrittingStatus(int creditScore) {
		String underWrittingStatus = "";
		
		if (creditScore >= 740 && creditScore <= 800) {
			underWrittingStatus = "Approved";
		} else if (creditScore >= 670 && creditScore <= 739 ) {
			underWrittingStatus = "Additional Check";
		}
		else {
			underWrittingStatus = "Rejected";
		} 
		
/*		System.out.println("creditScore (inside) : " + creditScore);
		System.out.println("underWrittingStatus (inside) : " + underWrittingStatus);*/
		
		return underWrittingStatus;
	}

}
