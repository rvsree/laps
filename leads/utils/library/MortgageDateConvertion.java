package com.mortgage.leads.utils.library;

import java.time.LocalDateTime;
import java.util.Date;

public class MortgageDateConvertion {

	public static java.sql.Date convertJavaToSQLDate(Date dateOfBirth) {
		System.out.println("Before Date Conversion: " + dateOfBirth);
		java.sql.Date convertDoB = new java.sql.Date(dateOfBirth.getDate());
		System.out.println("After Date Conversion: " + convertDoB);

		return convertDoB;
	}

	public static LocalDateTime getLocalDateTime(Date dateOfBirth) {
		LocalDateTime localDateTime = null;
		localDateTime = LocalDateTime.parse(dateOfBirth.toString());
		System.out.println("localDateTime: " + localDateTime);
		return localDateTime;
	}
	
}
