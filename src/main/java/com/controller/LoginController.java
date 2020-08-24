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

	// MUST FIX ISSUE WITH REDIRECT TO LOGIN FROM INDEX
	@GetMapping("/index")
	public String showIndex(ModelMap model) {
		return "/index";
	}

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

		// this clears the boxes and places a temp user to user
		// effectively "logs out" of the current user and would require loggin in again
		// BUG - whenever login page is visited it automatically logs out of current
		// user - FIX
		User cleanTemp = new User();
		model.put("user", cleanTemp);
		return "login";
	}

	@PostMapping("/login")
	public String loginSuccess(ModelMap model, @RequestParam String userName, @RequestParam String userPass) {

		List<User> uList = (List<User>) daoimpl.findAllUsers();

		// if the user input is wrong, displays this message
		if (!login.loginVerify(userName, userPass)) {
			model.put("errorMessage", "Invalid Credentials. Please Try Again");
			return "/login";
		} else {

			for (User user : uList) {
				if (user.getUserName().equalsIgnoreCase(userName) && user.getUserPass().equalsIgnoreCase(userPass)) {
					// uses replace to replace the temp user with new user login
					model.replace("user", user);
				}
			}
		}

		return "welcome";
	}

	@GetMapping("/myAccount")
	public String findingUser(ModelMap model) {

		return "myAccount";
	}

}
