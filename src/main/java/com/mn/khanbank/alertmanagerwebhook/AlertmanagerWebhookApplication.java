package com.mn.khanbank.alertmanagerwebhook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@ComponentScan(basePackages="com.mn.khanbank.alertmanagerwebhook")
@Slf4j
public class AlertmanagerWebhookApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlertmanagerWebhookApplication.class, args);
		System.out.println("Inside alertmanager service");
	}

}
