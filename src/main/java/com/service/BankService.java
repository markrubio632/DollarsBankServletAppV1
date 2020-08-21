package com.service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DaoImpl;
import com.model.User;

@Service
public class BankService {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	
	User tempUser = new User();
	
	@Autowired
	DaoImpl daoimpl;

	public double deposit(double balance, double amount) {

		// implementation is in controller
		// addHistory("deposit", amount);
		balance = balance + amount;
		return balance;
	}

	public double withdraw(double balance, double amount) {

		// implementation is in controller
		// addHistory("withdraw", amount);

		balance = balance - amount;
		return balance;
	}

	//work on implementing this with fund transfer verbage
	// (text, numbers)
	public String addHistory(String text, double numbers) {

		Timestamp timestamp = new Timestamp(DateFormat.FULL);

		return "You had a recent " + text + " of " + numbers + " at " + sdf.format(timestamp);
	}
	
	//to be used for working with receiver history
	/*
	 * public String addTransHistory(double numbers){
	 * 
	 * Timestamp ts = new Timestamp(DateFormat.FULL);
	 * 
	 * return "You received a Transfer of " + numbers + " at " + sdf.format(ts);
	 * 
	 * }
	 */

}
