package com.laps.customer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//tells Spring what section this class represents
@ConfigurationProperties(prefix="db")
//tells Spring to treat this class as a consumer of application.properties values
@EnableConfigurationProperties 
//tells Spring to treat this as a configuration class and register it as a Bean
@Configuration
@Component
public class DatabaseProperties {

	//@Value("${db.driverClass}")
	private String driverClass;

	//@Value("${db.connectionURL}")
	private String connectionURL;

	//@Value("${db.username}")
	private String username;

	//@Value("${db.password}")
	private String password;

	public String getDriverClass() {
		return driverClass;
	}


	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}


	public String getConnectionURL() {
		return connectionURL;
	}


	public void setConnectionURL(String connectionURL) {
		this.connectionURL = connectionURL;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "DatabaseProperties [driverClass=" + driverClass + ", connectionURL=" + connectionURL + ", username="
				+ username + ", password=" + password + "]";
	}
}
