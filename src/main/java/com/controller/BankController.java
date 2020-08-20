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

		System.out.println("user called, userBalance should be 0 and is: " + userBalance);
		userBalance = user.getUserBalance();
		System.out.println("user.getuserbalance is called and new userBalance is: " + userBalance);

		userBalance += bank.deposit(amount);
		System.out.println("userbalance post deposit is: " + userBalance);
		user.setUserBalance(userBalance);
		System.out.println("userbalance set is: " + userBalance);

		// update userbalance to the DB
		daoimpl.updateUser(user);

		history.add(bank.addHistory("deposit", amount));
		System.out.println("in deposit history: " + history.toString());
		return "mainPage";
	}

	// used to withdraw an amount
	@GetMapping("/withdraw")
	public String userWithdraw(ModelMap model) {

		// should bring up the withdraw page
		return "withdraw";

	}

	//MUST FIND WAY TO CLEAR THE AMOUNT USED
	@PostMapping("/withdraw")
	public String WithdrawSuccess(ModelMap model, double amount) {
		// creates a user instance from the previous user
		// this allows us to manipulate the model and the things inside
		// i.e being able to change the balance in the model
		User user = (User) model.getAttribute("user");

		//AMOUNT IS STILL AN ISSUE TO WORK ON
		userBalance = user.getUserBalance();

		System.out.println(userBalance);
		userBalance -= bank.withdraw(amount);
		user.setUserBalance(userBalance);
		
		// update userbalance to the DB
		daoimpl.updateUser(user);

		history.add(bank.addHistory("withdraw", amount));
		System.out.println("in withdraw history: " + history.toString());
		return "mainPage";
	}

	@GetMapping("/history")
	public String showHistory(ModelMap model) {
		// for now a console command - make a jsp for the results to be shown

		// loop to iterate through each record in the list
		for (String item : history) {
			//places the item in model, but doesnt show to the user
			model.put("item", item);
			System.out.println("inside history loop: " + item);
		}

		return "history";
	}

}
