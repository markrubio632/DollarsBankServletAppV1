package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DaoImpl;
import com.model.User;

@Service
public class LoginService {
	
	@Autowired
	User user;
	
	@Autowired
	DaoImpl daoimpl;
	
	public void loginVerify(String name, String pass) {

		//daoimpl.findAllUsers();
		
		if(user.getUserName() == name && user.getUserPass() == pass) {
			System.out.println("user is logged");
		}
		else {
			System.out.println("login failed");
		}
		
	}

}
