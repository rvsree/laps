package com.laps.gateway;

import com.netflix.zuul.ZuulFilter;

public class LapsGatewayFilter extends ZuulFilter {

	@Override
	public Object run() {
		System.out.println("Passed LAPS filter validation logic ...");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		
		return true;
	}

	@Override
	public int filterOrder() {
		
		return 1;
	}

	@Override
	public String filterType() {
		
		return "pre";
	}

}
