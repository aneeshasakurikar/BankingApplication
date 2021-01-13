package com.lti.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AccountLogin;
import com.lti.dto.AccountLoginStatus;
import com.lti.status.Status.StatusType;
import com.lti.entities.AccountDetails;
import com.lti.exceptions.CustomerServiceException;
import com.lti.services.AccountDetailsServiceImpl;
import com.lti.status.LoginStatus;

@RestController
public class AccountDetailsController {

	// @Autowired
	AccountDetailsServiceImpl accountDetailsService;

	@PostMapping(path = "/login")
	public void login(@RequestBody AccountLogin accountLogin) {

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

	}

	@PostMapping(path = "/forgotUserId")
	private void forgotUserId() {

	}

	@PostMapping(path = "/forgotLoginPassword")
	private void forgotPassword() {

	}

	@PostMapping(path = "/forgotTransactionPassword")
	private void forgotTransactionPassword() {

	}

}
