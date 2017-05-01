package com.laps.customer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="app")
@Component
public class ApplicationProperties {

	//@Value("${app.name}")
	private String name;

	//@Value("${app.sealid}")
	private String sealid;

	//@Value("${app.description}")
	private String description;

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
