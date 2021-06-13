package com.mn.khanbank.alertmanagerwebhook.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import lombok.Data;

@Data
public class SmsModel {

	private int priority;
	private String mobile;
	private String message;
}