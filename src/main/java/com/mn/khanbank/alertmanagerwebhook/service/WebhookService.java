package com.mn.khanbank.alertmanagerwebhook.service;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mn.khanbank.alertmanagerwebhook.model.AlertModel;
import com.mn.khanbank.alertmanagerwebhook.model.AlertWebhookModel;
import com.mn.khanbank.alertmanagerwebhook.model.SmsModel;
import com.mn.khanbank.alertmanagerwebhook.restintegration.SmsIntegrationService;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class WebhookService {

	@Autowired
	SmsIntegrationService smsint;

	@Value("#{${webhook.sms.mobile}}")
	private Map<String, List<String>> smsReceiver;

	public void sendMessageTestSms() {
		if (smsReceiver.containsKey("alerts-common"))
		{
			List<String> mobileNumberList = smsReceiver.get("alerts-common");
			System.out.println("sendMessageTestSms : mobileNumberList : "+ mobileNumberList);
			mobileNumberList.stream().forEach(moibleNumer -> {
				SmsModel smsmodel = new SmsModel(1,moibleNumer,"PING PONG");
				smsint.sendMessage(smsmodel);					
			});
		}
	}

	public void sendMessage(AlertWebhookModel alertmodel) {
		List<AlertModel> alertList = alertmodel.getAlerts();
		String receiver = alertmodel.getReceiver()!=null?alertmodel.getReceiver():"";
		if (!Objects.isNull(alertList) && smsReceiver.containsKey(receiver))
		{
			alertList.stream().forEach(alert -> {
				String message = alert.getAnnotations().containsKey("summary")?alert.getAnnotations().get("summary"):"Error Occured";
				List<String> mobileNumberList = smsReceiver.get(receiver);
				System.out.println("sendMessage : mobileNumberList : "+ mobileNumberList);
				mobileNumberList.stream().forEach(moibleNumer -> {
					SmsModel smsmodel = new SmsModel(1,moibleNumer,message);
					smsint.sendMessage(smsmodel);					
				});				
			});
		}
	}
}
