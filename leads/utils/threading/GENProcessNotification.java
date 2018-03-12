package com.mortgage.leads.utils.threading;

import java.util.concurrent.Callable;

import org.springframework.stereotype.Component;

@Component
public class GENProcessNotification implements Callable<Integer> {
	String fileInfo = "CAD_GEN_REQ_1";
	
	public GENProcessNotification() {
		//this.fileInfo = _fileInfo;
	}
	
	public int sendNotifcation() throws Exception {
		int processStatus = 0;
		try {
			this.retrieveNotification();
			this.generateXMLDocument();
			this.createPDFDocument();
			this.storeDocument();
			this.distributeNotification();
			this.updateStatus(); //Propagate status
			System.out.println("processing notification request: " + fileInfo); 
			processStatus = 1;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return processStatus;
	}

	@Override
	public Integer call() throws Exception {
		return this.sendNotifcation();
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
