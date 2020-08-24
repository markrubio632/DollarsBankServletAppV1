package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

	private double userBalance = 0;
	private double recBalance = 0;

	@GetMapping("/mainPage")
	public String showMain() {
		return "mainPage";
	}

	// used to deposit an amount
	@GetMapping("/deposit")
	public String userDepot(ModelMap model) {

		// should display the deposit page
		return "deposit";

	}

	@PostMapping("/deposit")
	public String deposSuccess(ModelMap model, double amount) {

		// creates a user instance from the previous user
		// this allows us to manipulate the model and the things inside
		// i.e being able to change the balance in the model
		User user = (User) model.getAttribute("user");

		userBalance = user.getUserBalance();

		userBalance = bank.deposit(userBalance, amount);
		// this updates the user balance in the model/user
		user.setUserBalance(userBalance);

		// update userbalance to the DB
		daoimpl.updateBalance(user);

		history.add(bank.addHistory("deposit", amount));
		System.out.println("in deposit history: " + history.toString());
		return "redirect:/mainPage";
	}

	// used to withdraw an amount
	@GetMapping("/withdraw")
	public String userWithdraw(ModelMap model) {

		// should bring up the withdraw page
		return "withdraw";

	}

	@PostMapping("/withdraw")
	public String WithdrawSuccess(ModelMap model, double amount1) {
		// creates a user instance from the previous user
		// this allows us to manipulate the model and the things inside
		// i.e being able to change the balance in the model
		User user = (User) model.getAttribute("user");
		userBalance = user.getUserBalance();

		userBalance = bank.withdraw(userBalance, amount1);
		user.setUserBalance(userBalance);

		// update userbalance to the DB
		daoimpl.updateBalance(user);

		history.add(bank.addHistory("withdraw", amount1));
		System.out.println("in withdraw history: " + history.toString());
		return "redirect:/mainPage";
	}

	@GetMapping("/fundTransfer")
	public String showTransfer(ModelMap model) {
		return "fundTransfer";
	}

	@PostMapping("/fundTransfer")
	public String transferSuccess(ModelMap model, int recId, double amount) {

		// this establishes the loggedin user by pulling from model
		User loggedUser = (User) model.getAttribute("user");

		// this creates our receiver as an object so we can work with it
		User receivingUser = daoimpl.findUserById(recId);

		// to be used for appending receiver histories
		// List<String> recHistory = new ArrayList<>();

		// establishes and carries out user balance
		userBalance = loggedUser.getUserBalance();
		userBalance = bank.withdraw(userBalance, amount);
		loggedUser.setUserBalance(userBalance);
		// update the logged in user balance to the DB
		daoimpl.updateBalance(loggedUser);

		// saves history for logged in user
		history.add(bank.addHistory("withdraw", amount));

		// establishes and carries out receiving balance
		recBalance = receivingUser.getUserBalance();
		recBalance = bank.deposit(recBalance, amount);
		receivingUser.setUserBalance(recBalance);
		// update the receiving user balance to the DB
		daoimpl.updateBalance(receivingUser);

		// IMPLEMENT HISTORY TO WORK WITH RECEIVER HISTORY
		// figure out how to store history and apply it to receiver
		// CONSIDER - making a DB for history and applying histories to that
		// recHistory.add(bank.addTransHistory(amount));

		return "mainPage";
	}

	@GetMapping("/history")
	public String showHistory(ModelMap model) {

		// appends the entire history (which has several items over-time)
		// to the model for JSP access
		model.put("history", history);

		return "history";
	}

}
