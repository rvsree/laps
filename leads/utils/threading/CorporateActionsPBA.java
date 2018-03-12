package com.mortgage.leads.utils.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Component;
import com.mortgage.leads.utils.exception.LeadsException;

@Component
public class CorporateActionsPBA {
	
	public void processNotifcationRequest(int requestCount) throws LeadsException {
		try {
			String requestInfo = "PBA_REQ_";
			ExecutorService executorService = Executors.newFixedThreadPool(3);			
			for(int index=1; index <= requestCount; index ++ )
			{
				System.out.println("initiating PBA notification: " + requestInfo + index);
				PBAProcessNotification pbaNotification = new PBAProcessNotification();
				executorService.submit(pbaNotification);
				System.out.println("queued PBA notification: " + requestInfo + index);			
			}
			executorService.shutdown();
			executorService.awaitTermination(60, TimeUnit.SECONDS);
		} catch (Exception ex) {
			System.out.println("ExecutorService threading exception occured.");
		}
	}
	
	
}
