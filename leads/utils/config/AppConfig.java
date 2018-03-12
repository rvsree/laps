package com.mortgage.leads.utils.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="spring.app")
public class AppConfig {

	//@Value("${app.name}")
	private String name;

	//@Value("${app.sealid}")
	private String sealid;

	//@Value("${app.description}")
	private String description;
	
	@Value("${spring.profiles.active}")
	private String activeEnviron;
	
	public String getActiveEnviron() {
		System.out.println("activeEnviron: " + activeEnviron);
		return activeEnviron;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSealid() {
		return sealid;
	}

	public void setSealid(String sealid) {
		this.sealid = sealid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ApplicationProperties [name=" + name + ", sealid=" + sealid + ", description=" + description+ "]";
	}
}
