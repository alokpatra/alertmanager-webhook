package com.mn.khanbank.alertmanagerwebhook.model;

import lombok.Data;

@Data
public class AlertModel {

	private String status;
	private Object labels;
	private Object annotations;
	private Object startsAt;
	private Object endsAt;
	private String generatorURL;
	private String fingerprint;

}