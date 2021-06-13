package com.mn.khanbank.alertmanagerwebhook.restintegration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mn.khanbank.alertmanagerwebhook.model.Response;
import com.mn.khanbank.alertmanagerwebhook.model.SmsModel;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class SmsIntegrationService {
	
	@Value("#{${send.sms.url}}")
	private String smsEndpoint;
	
	
	private RestTemplate restTemplate = new RestTemplate();
	
	public void sendMessage(SmsModel sms) {
		String endpoint = smsEndpoint;
		HttpHeaders header = new HttpHeaders();
		header.set("Content-Type", "application/json");
		HttpEntity<SmsModel> entity = new HttpEntity<SmsModel>(sms, header);
		ResponseEntity<Response> response = null;
		
		response = restTemplate.exchange(endpoint, HttpMethod.POST, entity, Response.class);
		
		
	}
	
}
