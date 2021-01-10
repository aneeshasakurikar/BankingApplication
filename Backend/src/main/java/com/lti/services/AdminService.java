package com.lti.services;

import com.lti.dto.AdminCredentials;
import com.lti.entities.Admin;

public interface AdminService {

	public Admin adminLogin(AdminCredentials adminCredentials);
}
