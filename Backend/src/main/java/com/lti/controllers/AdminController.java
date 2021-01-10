package com.lti.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AdminCredentials;
import com.lti.entities.Admin;
import com.lti.exceptions.ServiceException;
import com.lti.services.AdminService;
import com.lti.status.LoginStatus;
import com.lti.status.Status.statusType;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping(path = "/loginAdmin")
	public LoginStatus adminLogin(@RequestBody AdminCredentials adminCredentials) {
		try {
			Admin admin = adminService.adminLogin(adminCredentials);
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setName(admin.getAdminName());
			loginStatus.setUserId(admin.getAdminId());
			loginStatus.setMessage("Login Successful");
			loginStatus.setStatus(statusType.SUCCESS);
			return loginStatus;
		} catch (ServiceException e) {
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setMessage(e.getMessage());
			loginStatus.setStatus(statusType.FAILURE);
			return loginStatus;
		}
	}

}
