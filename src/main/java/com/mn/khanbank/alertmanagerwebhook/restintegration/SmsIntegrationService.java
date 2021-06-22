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
		System.out.println("sendMessage : endpoint : "+endpoint+" and sms : "+ sms);
		HttpHeaders header = new HttpHeaders();
		header.set("Content-Type", "application/json");
		HttpEntity<SmsModel> entity = new HttpEntity<SmsModel>(sms, header);
		ResponseEntity<Object> response = null;

		try {
			response = restTemplate.exchange(endpoint, HttpMethod.POST, entity, Object.class);
			System.out.println("sendMessage : response : " + response);

			if (response.getBody()!=null)
			{
				System.out.println("sendMessage : responsebody : " + response.getBody());
			}
			else {
				System.out.println("sendMessage : response body is empty");
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());

		}
	}
}
