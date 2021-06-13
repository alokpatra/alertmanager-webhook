package com.mn.khanbank.alertmanagerwebhook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mn.khanbank.alertmanagerwebhook.service.WebhookService;

@RestController("webhook")
public class WebhookController {
	
	@Autowired
	WebhookService webhookservice;
	
	@GetMapping(path = "/send-sms",consumes = {MediaType.APPLICATION_JSON_VALUE})
	public void sendMessage() {
		webhookservice.sendMessage();
	}
}
