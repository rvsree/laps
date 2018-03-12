package com.mortgage.leads.utils.library;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MortgageAspect {
	
	private Logger logger = Logger.getLogger(getClass().getName());

	@Before("execution(* com.mortgage.origination.mlops.controller..*(..))")
	public void logForAllMethods() {
		logger.info("logForAllMethods called ");
	}
}
