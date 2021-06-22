package com.mn.khanbank.alertmanagerwebhook.model;

import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AlertWebhookModel {
	
	private String version;
	private String groupKey;
	private int truncatedAlerts;
	private String status;
	private String receiver;
	private Object groupLabels;
	private Object commonLabels;
	private Object commonAnnotations;
	private String externalURL;
	private List<AlertModel> alerts;

}