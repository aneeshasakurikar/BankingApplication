package com.lti.services;

import javax.security.auth.login.AccountNotFoundException;

import com.lti.dto.AdminCredentials;
import com.lti.entities.Admin;

public interface AdminService {

	public Admin adminLogin(AdminCredentials adminCredentials) throws AccountNotFoundException;
}
