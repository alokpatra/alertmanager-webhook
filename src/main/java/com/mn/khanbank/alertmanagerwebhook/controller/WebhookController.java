package com.mn.khanbank.alertmanagerwebhook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mn.khanbank.alertmanagerwebhook.model.AlertWebhookModel;
import com.mn.khanbank.alertmanagerwebhook.service.WebhookService;

@RestController
//@RequestMapping("webhook")
public class WebhookController {
	
	@Autowired
	WebhookService webhookservice;
	
	@GetMapping(path = "/test-sms",consumes = {MediaType.ALL_VALUE})
	public void sendMessageTestSms() {
		webhookservice.sendMessageTestSms();
	}
	
	
	@PostMapping(path = "/send-sms",consumes = {MediaType.APPLICATION_JSON_VALUE})
	public void sendMessage(@RequestBody AlertWebhookModel alertmodel) {
		webhookservice.sendMessage(alertmodel);
	}
}
