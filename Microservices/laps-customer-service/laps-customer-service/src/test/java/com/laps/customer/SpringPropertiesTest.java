package com.laps.customer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.laps.customer.config.ApplicationProperties;
import com.laps.customer.config.DatabaseProperties;
import com.laps.customer.config.JmsProperties;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
//@ActiveProfiles(profiles = "dev")
//@Profile("sit")
@ContextConfiguration("classpath:xml-config-context.xml")
//@ContextConfiguration("classpath:mini-xml-config-context.xml")
//@EnableConfigurationProperties({ DatabaseProperties.class, ApplicationProperties.class })
@ComponentScan({"com.laps.customer"})
@EnableAutoConfiguration
public class SpringPropertiesTest extends TestCase {

	@Autowired
	private ApplicationProperties applicationProperties;

	@Autowired
	private DatabaseProperties databaseProperties;

	@Autowired
	private JmsProperties jmsProperties;
	
	@Test
	public void testApplicationProperties() {
		System.out.println("LAPS Application Properties        : " + applicationProperties.toString());
	}

	@Test
	public void testDatabaseProperties() {
		System.out.println("LAPS Database Properties: " + databaseProperties.toString());
	}
	
	@Test
	public void testJMSProperties() {
		System.out.println("LAPS JMS Properties     : " + jmsProperties.toString());
	}
}