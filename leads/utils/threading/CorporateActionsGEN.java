package com.mortgage.leads.utils.threading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.mortgage.leads.utils.exception.LeadsException;

import io.netty.util.concurrent.Future;

@Component
public class CorporateActionsGEN {
	
	public void processNotifcationRequest(int requestCount) throws LeadsException {
		try {
			String requestInfo = "GEN_REQ_";
			ExecutorService executorService = Executors.newFixedThreadPool(3);			
			Future<Integer>[] results = new Future[requestCount];  
			
			for(int index=1; index <= requestCount; index ++ )
			{
				System.out.println("initiating GEN notification: " + requestInfo + index);
				GENProcessNotification genNotification = new GENProcessNotification();
				results[index] = (Future<Integer>) executorService.submit(genNotification);
				System.out.println("queued GEN notification: " + requestInfo + index);			
			}
			
			for (Future<Integer> result: results) {
				try {
					int value = result.get();
					System.out.println("Value is : " + value);
				} catch (ExecutionException ex) {
					Throwable senderEx = ex.getCause();
					System.out.println("ExecutionException occured: " + ex.getCause() );					
				}
			}
			//executorService.shutdown();
			//executorService.awaitTermination(60, TimeUnit.SECONDS);
		} catch (Exception ex) {
			System.out.println("ExecutorService threading exception occured.");
		}
	}
 	
}
