package com.laps.customer.thread;

import java.io.IOException;
import java.util.concurrent.Callable;

public class DocumentManagerCallable implements Callable<String> {
	String createFile;

	public DocumentManagerCallable(String createFile) {
		this.createFile = createFile;
	}

	public String retieveEvents(String createFile) throws IOException {

		String status = "";
		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " Retieved Events : " + createFile);
			this.generateFile(createFile);
			status = "Notification process completed for :" + createFile;
		} catch (InterruptedException e) {
			status = "Notification process failed for :" + createFile;
			e.printStackTrace();
		}
		return status;
	}

	public void generateFile(String createFile) throws IOException {

		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " Generated XML File : " + createFile);
			this.createDocument(createFile);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void createDocument(String createFile) throws IOException {

		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " Created PDF Document : " + createFile);
			this.distribute(createFile);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void distribute(String createFile) throws IOException {

		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " Distribute Initiated : " + createFile);
			this.updateMetadata(createFile);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void updateMetadata(String createFile) {

		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " Persisted Status in Database: " + createFile);
			this.alertLogic(createFile);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void alertLogic(String createFile) {

		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " Notified Downstream Systems: " + createFile);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String call() throws Exception {
		String status = "";
		status = this.retieveEvents(this.createFile);
		return status;
	}
}
