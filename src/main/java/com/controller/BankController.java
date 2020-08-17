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

	//static List<User> jeeves = new ArrayList<User>();
	
	@GetMapping("/register")
	public String showRegister(ModelMap model) {
		User user = new User();
		model.addAttribute(user);
		
		return "register";
	}

	@PostMapping("/register")
	public String registerSuccess(ModelMap model, @RequestParam String userName, @RequestParam String userPass,

			@RequestParam String userAddress, @RequestParam String userContact, @RequestParam double userBalance,

			@RequestParam String userAcc) {

		model.put("userName", userName);
		model.put("userPass", userPass);
		model.put("userAddress", userAddress);
		model.put("userContact", userContact);
		model.put("userBalance", userBalance);
		model.put("userAcc", userAcc);

		//daoimpl.saveUser(new User(0, userName, userPass, userAddress, userContact, userBalance, userAcc));
		repo.save(new User(0, userName, userPass, userAddress, userContact, userBalance, userAcc));
		//jeeves.add(new User(0, userName, userPass, userAddress, userContact, userBalance, userAcc));
		return "myAccount";
	}

	/*
	 * @GetMapping("/myAccount") public String findUserInsert(ModelMap model) {
	 * Object name = model.getAttribute("userName");
	 * System.out.println("object name: "+name);
	 * System.out.println("in my account, model get attribute is: " + model); User
	 * user = (User) model.get(model); System.out.println("user is: "+ user);
	 * 
	 * return "myAccount"; }
	 * 
	 * @PostMapping("/myAccount") public String findUserOutput(ModelMap
	 * model, @RequestParam int id) {
	 * 
	 * 
	 * return "myAccount"; }
	 */

	@GetMapping("/myAccount")
	public String findingUser(ModelMap model) {

		List<User> uList = (List<User>) daoimpl.findAllUsers();

		model.put("uList", uList);
		System.out.println(uList);

		return "myAccount";
	}
	
	//used to deposit an amount
	@GetMapping("/deposit")
	public String userDepot(ModelMap model, double amount, @RequestParam Double userBalance) {
		
		userBalance += bank.deposit(amount);
		history.add(bank.addHistory("deposit", amount));
		
		//probably should go to myAccount
		return "deposit";
		
	}
	
	//used to withdraw an amount
		@GetMapping("/withdraw")
		public String userWithdraw(ModelMap model, double amount, @RequestParam Double userBalance) {
			
			userBalance -= bank.withdraw(amount);
			history.add(bank.addHistory("withdraw", amount));
			
			//probably should go to myAccount
			return "withdraw";
			
		}

}
