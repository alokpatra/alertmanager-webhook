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


@Service
public class WebhookService {

	@Autowired
	SmsIntegrationService smsint;

	@Value("#{${webhook.sms.mobile}}")
	private Map<String, List<String>> smsReceiver;

	public void sendMessageTestSms() {
		if (smsReceiver.containsKey("alerts-common"))
		{
			List<String> mobileNumberList = smsReceiver.get("alerts-common");
			for(String moibleNumer : mobileNumberList)
			{
				SmsModel smsmodel = new SmsModel();
				smsmodel.setPriority(1);
				smsmodel.setMessage("PING PONG");			
				smsmodel.setMobile(moibleNumer);
				smsint.sendMessage(smsmodel);
			}
		}
	}

	public void sendMessage(AlertWebhookModel alertmodel) {
		List<AlertModel> alert = alertmodel.getAlerts();
		String receiver = alertmodel.getReceiver()!=null?alertmodel.getReceiver():"";
		if (Objects.nonNull(alert))
		{
			Map<String, String> annotation = alert.getAnnotations();
			if (smsReceiver.containsKey(receiver))
			{
				List<String> mobileNumberList = smsReceiver.get(receiver);
				for(String moibleNumer : mobileNumberList)
				{
					SmsModel smsmodel = new SmsModel();
					smsmodel.setPriority(1);
					smsmodel.setMessage("PING PONG");			
					smsmodel.setMobile(moibleNumer);
					smsint.sendMessage(smsmodel);
				}
			}
		}

	}
}
