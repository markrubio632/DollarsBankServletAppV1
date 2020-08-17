package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="dollarsbank")
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="userName")
	private String userName;
	@Column(name="userPass")
	private String userPass;
	@Column(name="userAddress")
	private String userAddress;
	@Column(name="userContact")
	private String userContact;
	@Column(name="userBalance")
	private double UserBalance;
	@Column(name="userAcc")
	private String userAcc;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserContact() {
		return userContact;
	}
	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}
	public double getUserBalance() {
		return UserBalance;
	}
	public void setUserBalance(double userBalance) {
		UserBalance = userBalance;
	}
	public String getUserAcc() {
		return userAcc;
	}
	public void setUserAcc(String userAcc) {
		this.userAcc = userAcc;
	}
	
	public User(int id, String userName, String userPass, String userAddress, String userContact, double userBalance,
			String userAcc) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPass = userPass;
		this.userAddress = userAddress;
		this.userContact = userContact;
		UserBalance = userBalance;
		this.userAcc = userAcc;
	}
	@Autowired
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", userName=" + userName + ", userPass=" + userPass + ", userAddress=" + userAddress
				+ ", userContact=" + userContact + ", UserBalance=" + UserBalance + ", userAcc=" + userAcc + "]";
	}
	
}
