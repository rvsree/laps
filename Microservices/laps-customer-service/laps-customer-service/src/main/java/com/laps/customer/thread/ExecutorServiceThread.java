package com.laps.customer.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceThread {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(5);
		String createFile = "IPBJIB_ME_N10";

		for (int index = 0; index < 3; index ++) {
			Runnable workerDocumentManager = new DocumentManagerExecutor(createFile + index);
			executor.execute(workerDocumentManager);
		}

		try {
			executor.shutdown();

			while (!executor.isTerminated()) { }
			System.out.println("Finished all threads");
			executor.awaitTermination(60, TimeUnit.SECONDS);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
