package com.service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BankService {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	
	private double balance;
	
	public double deposit(double amount) {
		return balance += amount;
	}
	
	public double withdraw(double amount) {
		return balance -= amount;
	}
	
	//(text, numbers)
	public String addHistory(String text, double numbers) {
		
		Timestamp timestamp = new Timestamp(DateFormat.FULL);
		
		return "You had a recent " + text + " of " + numbers + " at " + sdf.format(timestamp);
	}

}
