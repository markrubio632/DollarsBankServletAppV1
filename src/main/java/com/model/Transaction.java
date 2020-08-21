package com.model;

public class Transaction {
	
	private int recId;
	private double amount;
	public int getRecId() {
		return recId;
	}
	public void setRecId(int recId) {
		this.recId = recId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Transaction(int recId, double amount) {
		super();
		this.recId = recId;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Transaction [recId=" + recId + ", amount=" + amount + "]";
	}
	
	

}
