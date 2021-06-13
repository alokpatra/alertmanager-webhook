package com.mn.khanbank.alertmanagerwebhook.model;

import java.util.Map;

import lombok.Data;

@Data
public class AlertModel {

	private String status;
	private Object labels;
	private Map<String, String> annotations;
	private Object startsAt;
	private Object endsAt;
	private String generatorURL;
	private String fingerprint;

}