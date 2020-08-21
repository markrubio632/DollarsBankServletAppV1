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

import com.model.Transaction;
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
		daoimpl.updateUser(user);

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

	// MUST FIND WAY TO CLEAR THE AMOUNT USED
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
		daoimpl.updateUser(user);

		history.add(bank.addHistory("withdraw", amount1));
		System.out.println("in withdraw history: " + history.toString());
		return "redirect:/mainPage";
	}
	
	@GetMapping("/fundTransfer")
	public String showTransfer(ModelMap model) {
		return "fundTransfer";
	}
	
	//name param will be used for naming what user to give to (id used for identifying)
	@PostMapping("/fundTransfer")
	public String transferSuccess(ModelMap model, String name, int receiverId) {
		
		//this establishes the loggedin user by pulling from model
		User loggedUser = (User) model.getAttribute("user");
		
		//this creates our receiver as an object so we can work with it
		User receivingUser = daoimpl.findUserById(receiverId);
		
		
		
		return "mainPage";
	}

	@GetMapping("/history")
	public String showHistory(ModelMap model) {

		System.out.println("master history list: " + history.toString());

		// appends the entire history (which has several items over-time)
		// to the model for JSP access
		model.put("history", history);

		return "history";
	}

}
