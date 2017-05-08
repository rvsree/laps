package com.laps.customer.thread;

import java.io.IOException;
import java.util.concurrent.Callable;

public class DocumentManagerExecutor implements Runnable {
	String createFile;

	public DocumentManagerExecutor(String createFile) {
		this.createFile = createFile;
	}
	
	public void retieveEvents(String createFile) throws IOException {

		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " Retieved Events : " + createFile);
			this.generateFile(createFile);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

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
	public void run() {
		try {
			this.retieveEvents(this.createFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
