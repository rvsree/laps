package com.mortgage.maps.utils.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAspectJAutoProxy
//@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@Component
public class DataSourceConfig {

	@Autowired
	private Environment environ;

	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(environ.getProperty("spring.datasource.driverClassName"));
		dataSource.setUrl(environ.getProperty("spring.datasource.url"));
		dataSource.setUsername(environ.getProperty("spring.datasource.userName"));
		dataSource.setPassword(environ.getProperty("spring.datasource.password"));
		dataSource.setInitialSize(Integer.parseInt(environ.getProperty("spring.datasource.minConnPoolSize")));
		return dataSource;
	} 
	
	//@Bean(name="transactionManager")
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
}
