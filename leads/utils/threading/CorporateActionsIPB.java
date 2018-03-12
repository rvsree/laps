package com.mortgage.leads.utils.threading;

import org.springframework.stereotype.Component;

import com.mortgage.leads.utils.exception.LeadsException;

@Component
public class CorporateActionsIPB {
	
	public void processNotifcationRequest(int requestCount) throws LeadsException {

		String requestInfo = "IPB_REQ_";
		Thread[] notifyThreads = new Thread[requestCount];
		
		for(int index=1; index <= requestCount; index ++ )
		{
			IPBProcessNotification ipbNotification = new IPBProcessNotification();
			notifyThreads[index] = new Thread(ipbNotification);
			System.out.println("initiating IPB notification : " + requestInfo + index);			
			notifyThreads[index].start();
			System.out.println("queued IPB notification : " + requestInfo + index);			
		}
		
		for (Thread thread: notifyThreads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
