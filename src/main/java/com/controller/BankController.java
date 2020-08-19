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
	public String userDepot(ModelMap model) {

		//should display the deposit page
		return "deposit";

	}
	
	@PostMapping("/deposit")
	public String deposSuccess(ModelMap model, double amount, @RequestParam double userBalance) {
		userBalance += bank.deposit(amount);
		history.add(bank.addHistory("deposit", amount));
		System.out.println("in deposit history: " + history.toString());
		return "deposit";
	}

	// used to withdraw an amount
	@GetMapping("/withdraw")
	public String userWithdraw(ModelMap model) {

		//should bring up the withdraw page
		return "withdraw";

	}
	
	@PostMapping("/withdraw")
	public String WithdrawSuccess(ModelMap model, double amount, @RequestParam Double userBalance) {
		userBalance -= bank.withdraw(amount);
		history.add(bank.addHistory("withdraw", amount));
		System.out.println("in withdraw history: " + history.toString());
		// probably should go to myAccount
		return "withdraw";
	}
	
	@GetMapping("/history")
	public String showHistory(ModelMap model) {
		//for now a console command - make a jsp for the results to be shown
		
		//loop to iterate through each record in the list
		for(String item : history) {
			model.put("item", item);
			System.out.println("inside history loop: " + item);
		}
		
		return "history";
	}

}
