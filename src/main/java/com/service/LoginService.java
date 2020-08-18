package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DaoImpl;
import com.model.User;

@Service
public class LoginService {

	@Autowired
	DaoImpl daoimpl;
	
	int iterator = 0;
	
	public boolean loginVerify(String name, String pass) {

		List<User> userList = daoimpl.findAllUsers();

		for (User user : userList) {

			if (user.getUserName().equalsIgnoreCase(name) && user.getUserPass().equalsIgnoreCase(pass)) {
				return true;
			}

		}
		return false;
	}

}
