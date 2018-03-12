package com.mortgage.leads.utils.threading;

import org.springframework.stereotype.Component;

@Component
public class PBAProcessNotification implements Runnable {
	String fileInfo = "CAD_PBA_REQ_1";
	
	public PBAProcessNotification() {
		 
	}
	
	public void sendNotifcation() {
		try {
			this.retrieveNotification();
			this.generateXMLDocument();
			this.createPDFDocument();
			this.storeDocument();
			this.distributeNotification();
			this.updateStatus(); //Propagate status
			System.out.println("processing notification request: " + fileInfo); 
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			this.sendNotifcation();
		} catch(Exception ex) {
			
		}
	}

	private void retrieveNotification() throws InterruptedException {
		Thread.sleep(500);
	}

	private void generateXMLDocument() throws InterruptedException {
		Thread.sleep(500);
	}
	private void createPDFDocument() throws InterruptedException {
		Thread.sleep(500);
	}

	private void storeDocument() throws InterruptedException {
		Thread.sleep(500);
	}

	private void distributeNotification() throws InterruptedException {
		Thread.sleep(500);
	}

	private void updateStatus() throws InterruptedException {
		Thread.sleep(500);
	}

}
