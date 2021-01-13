package com.lti.dto;

import com.lti.status.Status;

public class RegisterStatus extends Status{

	private int registeredUserId;

	public int getRegisteredUserId() {
		return registeredUserId;
	}

	public void setRegisteredCustomerId(int registeredUserId) {
		this.registeredUserId = registeredUserId;
	}

}
