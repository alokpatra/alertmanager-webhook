package com.mn.khanbank.alertmanagerwebhook.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmsModel {

	private int priority;
	private String mobile;
	private String message;
}