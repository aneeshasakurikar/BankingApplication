package com.lti.controllers;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AccountLogin;
import com.lti.services.AccountDetailsServiceImpl;
import com.lti.status.LoginStatus;
import com.lti.status.Status;
import com.lti.status.Status.StatusType;

@RestController
public class AccountDetailsController {

	@Autowired
	AccountDetailsServiceImpl accountDetailsService;

	@PostMapping(path = "/login")
	public LoginStatus login(@RequestBody AccountLogin accountLogin) {

//		try {
//			AccountDetails accountDetails = accountDetailsService.accountLogin(accountLogin.getUserId(), accountLogin.getPassword());
//			AccountLoginStatus status = new AccountLoginStatus();
//			status.setStatus(StatusType.SUCCESS);
//			status.setMessage("Login Successful!");
//			status.setCustomerId(customer.getId());
//			status.setCustomerName(customer.getName());
//			return status;
//		} catch (CustomerServiceException e) {
//			LoginStatus status = new LoginStatus();
//			status.setStatus(StatusType.FAILED);
//			status.setMessage(e.getMessage());
//			return status;
//		}
		
		try {
			boolean res = accountDetailsService.loginUser(accountLogin);
			LoginStatus status = new LoginStatus();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Login Successful!");
			status.setUserId(accountLogin.getUserId());
			return status;
		}
		catch(ServiceException e) {
			LoginStatus status = new LoginStatus();
			status.setStatus(StatusType.FAILED);
			status.setMessage(e.getMessage());
			return status;			
		}

	}

	
//	@PostMapping(path="/checkStatus")
//	private Status checkStatus(@RequestBody int userId) {
//		try {
//			String userStatus = accountDetailsService.checkUserStatus(userId);
//			Status status = new Status();
//			status.setStatus(StatusType.SUCCESS);
//			status.setMessage(userStatus);
//		}
//		catch(ServiceException e) {
//			LoginStatus status = new LoginStatus();
//			status.setStatus(StatusType.FAILED);
//			status.setMessage(e.getMessage());
//			return status;			
//		}
//	}

	@PostMapping(path = "/forgotLoginPassword")
	private void forgotPassword() {

	}

	@PostMapping(path = "/forgotTransactionPassword")
	private void forgotTransactionPassword() {

	}

}
