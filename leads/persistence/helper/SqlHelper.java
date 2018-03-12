package com.mortgage.leads.persistence.helper;

import java.io.IOException;
import java.io.File;
import java.nio.file.Files;

public class SqlHelper {

	public static String getCustomerSql() throws IOException  {
        ClassLoader classLoader = new SqlHelper().getClass().getClassLoader();
        File file = new File(classLoader.getResource("sqlscripts/customer.sql").getFile());
        String sqlScriptUrl = new String(Files.readAllBytes(file.toPath()));
		//System.out.println("sqlScriptUrl: " + sqlScriptUrl);
		return sqlScriptUrl;
	}
}
