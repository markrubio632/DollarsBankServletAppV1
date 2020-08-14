package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.model.User;
import com.repository.CRUDRepo;
import com.dao.DaoImpl;

@Controller
@SessionAttributes("user")
public class BankController {
	
	/*
	 * @Autowired DaoImpl daoImpl;
	 */

	@Autowired
	CRUDRepo repo;

	@GetMapping("/register")
	public String showLogin(ModelMap model) {
		User user = new User();
		model.addAttribute(user);
		return "register";
	}

	@PostMapping("/register")
	public String loginSuccess(ModelMap model, @RequestParam String userName, @RequestParam String userPass,
			@RequestParam String userAddress, @RequestParam String userContact, @RequestParam double userBalance,
			@RequestParam String userAcc) {

		model.put("userName", userName);
		model.put("userPass", userPass);
		model.put("userAddress", userAddress);
		model.put("userContact", userContact);
		model.put("userBalance", userBalance);
		model.put("userAcc", userAcc);

		// daoimpl.saveUser(new User(0, userName, userPass, userAddress, userContact,
		// userBalance, userAcc));

		repo.save(new User(0, userName, userPass, userAddress, userContact, userBalance, userAcc));

		return "registerSuccess";
	}

}
