package com.mortgage.leads.utils.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.stereotype.Component;

import com.mortgage.leads.web.security.UserAccountService;

@Component
public class X509SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserAccountService userAccountService;
	
/*	//@Override
	protected UserAccountService userAccountService() {
		return this.userAccountService;
	}
	*/
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		/*
		 * http //.authorizeRequests().anyRequest().authenticated() //.and()
		 * .httpBasic() .and() .csrf().disable() .headers() .frameOptions().disable();
		 */

		httpSecurity.authorizeRequests().anyRequest().authenticated()
			.and()
				.x509()
			.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
			.and()
				.headers().frameOptions().disable()
			.and()
				.headers().frameOptions().sameOrigin()
			.and()
				.csrf().disable();

	}
}
