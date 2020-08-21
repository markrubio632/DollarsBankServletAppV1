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

	public double deposit(double balance, double amount) {

		// addHistory("deposit", amount);
		balance = balance + amount;
		return balance;
	}

	public double withdraw(double balance, double amount) {

		// addHistory("withdraw", amount);

		balance = balance - amount;
		return balance;
	}

	public double fundTransfer(double balance, double amount, String loggedName, int receiverId) {

		balance = balance - amount;

		return balance;

	}

	// (text, numbers)
	public String addHistory(String text, double numbers) {

		Timestamp timestamp = new Timestamp(DateFormat.FULL);

		return "You had a recent " + text + " of " + numbers + " at " + sdf.format(timestamp);
	}

}
