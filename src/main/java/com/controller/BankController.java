package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.model.User;
import com.repository.CRUDRepo;
import com.service.BankService;
import com.dao.DaoImpl;

@Controller
@SessionAttributes("user")
public class BankController {

	@Autowired
	DaoImpl daoimpl;

	@Autowired
	CRUDRepo repo;

	@Autowired
	BankService bank;

	List<String> history = new ArrayList<>();

	private double balance;


	// used to deposit an amount
	@GetMapping("/deposit")
	public String userDepot(ModelMap model, double amount, @RequestParam Double userBalance) {

		userBalance += bank.deposit(amount);
		history.add(bank.addHistory("deposit", amount));

		// probably should go to myAccount
		return "deposit";

	}

	// used to withdraw an amount
	@GetMapping("/withdraw")
	public String userWithdraw(ModelMap model, double amount, @RequestParam Double userBalance) {

		userBalance -= bank.withdraw(amount);
		history.add(bank.addHistory("withdraw", amount));

		// probably should go to myAccount
		return "withdraw";

	}

}
