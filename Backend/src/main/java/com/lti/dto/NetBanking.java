package com.lti.dto;

public class NetBanking {
	int userId;
	String initialLoginPassword;
	String initialTransactionPassword;
	String finalLoginPassword;
	String finalTransactionPassword;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getInitialLoginPassword() {
		return initialLoginPassword;
	}

	public void setInitialLoginPassword(String initialLoginPassword) {
		this.initialLoginPassword = initialLoginPassword;
	}

	public String getInitialTransactionPassword() {
		return initialTransactionPassword;
	}

	public void setInitialTransactionPassword(String initialTransactionPassword) {
		this.initialTransactionPassword = initialTransactionPassword;
	}

	public String getFinalLoginPassword() {
		return finalLoginPassword;
	}

	public void setFinalLoginPassword(String finalLoginPassword) {
		this.finalLoginPassword = finalLoginPassword;
	}

	public String getFinalTransactionPassword() {
		return finalTransactionPassword;
	}

	public void setFinalTransactionPassword(String finalTransactionPassword) {
		this.finalTransactionPassword = finalTransactionPassword;
	}

}
