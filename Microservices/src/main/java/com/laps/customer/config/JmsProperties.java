package com.laps.customer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="jms")
public class JmsProperties {

	//@Value("${jms.factory.initial}")
	private String factoryInitial;

	//@Value("${jms.provider.url}")
	private String providerUrl;

	//@Value("${jms.queue}")
	private String queue;

	public String getFactoryInitial() {
		return factoryInitial;
	}

	public String getProviderUrl() {
		return providerUrl;
	}

	public String getQueue() {
		return queue;
	}

	@Override
	public String toString() {
		return "JmsProperties [factoryInitial=" + factoryInitial + ", providerUrl=" + providerUrl + ", queue=" + queue
				+ "]";
	}

}
