package com.laps.notification;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@SpringBootApplication
@EnableTask
public class LapsNotificationTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(LapsNotificationTaskApplication.class, args);
	}

	@Bean
	public LoanProcessingTask loanProcessingTask() {
		return new LoanProcessingTask();
	}

	public class LoanProcessingTask implements CommandLineRunner {

		@Override
		public void run(String... payload) throws Exception {
			// parameters: customerId, applicationId, appliedDate

			if (null != payload) {
				String customerId = payload[1];
				String applicationId = payload[2];
				String appliedDate = payload[3];

				System.out.println("customerId is: " + customerId + ", applicationId is: " + applicationId + ", appliedDate is: " + appliedDate);

				writeToFile(customerId, applicationId, appliedDate);
			}
		}

		private void writeToFile(String customerId, String applicationId, String appliedDate) {
			
			final String FILENAME = "C:\\Dev\\Java\\Workspace\\GIT\\Microservices\\laps-notification-task\\src\\main\\resources\\Order.txt";

			BufferedWriter bw = null;
			FileWriter fw = null;

			try {

				//String content = "This is the content to write into file\n";

				fw = new FileWriter(FILENAME);
				bw = new BufferedWriter(fw);
				bw.write("customerId is: " + customerId + ", applicationId is: " + applicationId + ", appliedDate is: " + appliedDate);

				System.out.println("Done");

			} catch (IOException e) {

				e.printStackTrace();

			} finally {

				try {

					if (bw != null)
						bw.close();

					if (fw != null)
						fw.close();

				} catch (IOException ex) {

					ex.printStackTrace();

				}

			}
	    }
		
	}
}
