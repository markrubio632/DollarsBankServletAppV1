package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dao.DaoImpl;
import com.model.User;
import com.repository.CRUDRepo;
import com.service.LoginService;

@Controller
@SessionAttributes("user")
public class LoginController {

	// login controller holds logic to be used for User accounts

	@Autowired
	DaoImpl daoimpl;

	@Autowired
	LoginService login;

	@Autowired
	CRUDRepo repo;

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

		repo.save(new User(0, userName, userPass, userAddress, userContact, userBalance, userAcc));

		return "redirect:/login";
	}

	@GetMapping("/login")
	public String showLogin(ModelMap model) {

		return "login";
	}

	@PostMapping("/login")
	public String loginSuccess(ModelMap model, @RequestParam String userName, @RequestParam String userPass) {

		List<User> uList = (List<User>) daoimpl.findAllUsers();

		if (!login.loginVerify(userName, userPass)) {
			model.put("errorMessage", "Invalid Credentials");
		} else {

			for (User user : uList) {
				if (user.getUserName().equalsIgnoreCase(userName) && user.getUserPass().equalsIgnoreCase(userPass)) {
					model.put("user", user);
				}
			}
		}

		return "welcome";
	}

	@GetMapping("/myAccount")
	public String findingUser(ModelMap model) {

		System.out.println("in my account,the before model is: " + model);

		List<User> uList = (List<User>) daoimpl.findAllUsers();

		// this loops through all users and prints to the user
		// the most recent user is the ending model that is shown. must fix/implement
		// login function
		for (User user : uList) {

			model.put("user", user);
			System.out.println("inside myacc loop, user is: " + user);

		}
		// -----------------

		System.out.println("in my account,the after model is: " + model);

		return "myAccount";
	}

}
