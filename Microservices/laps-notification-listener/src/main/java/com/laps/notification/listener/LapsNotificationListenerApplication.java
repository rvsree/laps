package com.laps.notification.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.launcher.annotation.EnableTaskLauncher;

@SpringBootApplication
@EnableTaskLauncher
public class LapsNotificationListenerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LapsNotificationListenerApplication.class, args);
	}
}
