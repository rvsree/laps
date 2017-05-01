package com.laps.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.laps.customer.model.CustomerModel;
import com.laps.customer.repository.CustomerRepoistory;

@Service
public class CustomerAsyncService {

	@Autowired
	CustomerRepoistory customerRepoistory;

	@Async
	public CustomerModel fetchCustomer() {
		long time = System.currentTimeMillis();

		try {
			Thread.sleep(5000);
			System.out.println(String.format("Task completed after %d milliseconds", System.currentTimeMillis() - time));			
			return customerRepoistory.retrieveCustomer();
		} catch (InterruptedException e) {
			// We've been interrupted
			System.out.println(
					String.format("Task interrupted after %d milliseconds", System.currentTimeMillis() - time));
			return null;
		}
	}
}
