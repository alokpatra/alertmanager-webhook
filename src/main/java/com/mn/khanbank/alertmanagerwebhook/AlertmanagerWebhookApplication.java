package com.mn.khanbank.alertmanagerwebhook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.mn.khanbank.alertmanagerwebhook")
public class AlertmanagerWebhookApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlertmanagerWebhookApplication.class, args);
	}

}
