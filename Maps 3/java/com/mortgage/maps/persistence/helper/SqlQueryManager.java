package com.mortgage.maps.persistence.helper;

import java.io.IOException;

public class SqlQueryManager {

	public static String getCustomerSql() {
		String customerSql = "";
		try {
			customerSql = SqlHelper.getCustomerSql();
		} catch (IOException ex) {
			System.out.println("Exception in Query Manager: " + ex.getMessage());
		}
		return customerSql;
	}
}
