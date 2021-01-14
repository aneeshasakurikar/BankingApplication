package com.lti.dto;

public class TransactionDTO {
	int fromAccount;
	int toAccount;
	int amount;
	int transactionPassword;
	String transactionMode;
	public String getTransactionMode() {
		return transactionMode;
	}
	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}
	public int getTransactionPassword() {
		return transactionPassword;
	}
	public void setTransactionPassword(int transactionPassword) {
		this.transactionPassword = transactionPassword;
	}
	public int getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(int fromAccount) {
		this.fromAccount = fromAccount;
	}
	public int getToAccount() {
		return toAccount;
	}
	public void setToAccount(int toAccount) {
		this.toAccount = toAccount;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	

}
