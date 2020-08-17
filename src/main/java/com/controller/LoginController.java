package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dao.DaoImpl;
import com.model.User;
import com.service.LoginService;

@Controller
@SessionAttributes("user")
public class LoginController {

	@Autowired
	DaoImpl daoimpl;
	
	@Autowired
	LoginService login;

	@GetMapping("/login")
	public String showLogin(ModelMap model) {

		return "login";
	}

	@PostMapping("/login")
	public String loginSuccess(ModelMap model, @RequestParam String userName, @RequestParam String userPass) {

		login.loginVerify(userName, userPass);

		model.put("userName", userName);
		model.put("userPass", userPass);

		return "myAccount";
	}

}
