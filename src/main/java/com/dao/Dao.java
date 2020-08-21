package com.dao;

import java.util.List;

import com.model.User;

public interface Dao{
	
	public int saveUser(User user);
	
	public List<User> findAllUsers();
	
	public User findUserById(int id);
	
	public void deleteUser(User user);
	
	//only set to update balance, but can be improved for the whole user
	public int updateBalance(User user);

}
