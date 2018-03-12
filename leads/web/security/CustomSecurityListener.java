package com.mortgage.leads.web.security;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.stereotype.Component;

@Component
public class CustomSecurityListener implements ApplicationListener<AbstractAuthenticationFailureEvent> {

	@Override
	public void onApplicationEvent(AbstractAuthenticationFailureEvent authFaileureEvent) {
			System.out.println("authFaileureEvent: " + authFaileureEvent.getException().getMessage());
	}
}
