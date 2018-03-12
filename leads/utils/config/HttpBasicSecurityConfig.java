package com.mortgage.leads.utils.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
public class HttpBasicSecurityConfig extends WebSecurityConfigurerAdapter {

	/*@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		
		 * http //.authorizeRequests().anyRequest().authenticated() //.and()
		 * .httpBasic() .and() .csrf().disable() .headers() .frameOptions().disable();
		 

		httpSecurity.authorizeRequests().antMatchers("/").permitAll().and().authorizeRequests()
				.antMatchers("/console/**").permitAll();

		httpSecurity.csrf().disable();
		httpSecurity.headers().frameOptions().disable();
		httpSecurity.headers().frameOptions().sameOrigin();

	}*/
}
