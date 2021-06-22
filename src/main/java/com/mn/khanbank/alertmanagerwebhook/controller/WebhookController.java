package com.mn.khanbank.alertmanagerwebhook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mn.khanbank.alertmanagerwebhook.model.AlertWebhookModel;
import com.mn.khanbank.alertmanagerwebhook.service.WebhookService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
//@RequestMapping("webhook")
public class WebhookController {
	
	@Autowired
	WebhookService webhookservice;
	
	@GetMapping(path = "/test-sms",consumes = {MediaType.ALL_VALUE})
	public void sendMessageTestSms() {
		System.out.println("Inside sendMessageTestSms");
		webhookservice.sendMessageTestSms();
		System.out.println("Completed sendMessageTestSms");
	}
	
	
	@PostMapping(path = "/send-sms",consumes = {MediaType.APPLICATION_JSON_VALUE})
	public void sendMessage(@RequestBody AlertWebhookModel alertmodel) {
		System.out.println("Inside sendMessage : " + alertmodel);
		webhookservice.sendMessage(alertmodel);
		System.out.println("Completed sendMessage");
	}
}
