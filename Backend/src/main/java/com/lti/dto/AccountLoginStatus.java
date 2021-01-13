package com.lti.dto;

import com.lti.status.Status;

public class AccountLoginStatus extends Status{
	
	private int userId;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
