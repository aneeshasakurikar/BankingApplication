package com.lti.controllers;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AccountLogin;
import com.lti.dto.ForgotLoginPasswordDTO;
import com.lti.dto.ForgotUserIdDTO;
import com.lti.dto.NetBanking;
import com.lti.entities.AccountDetails;
import com.lti.services.AccountDetailsServiceImpl;
import com.lti.status.LoginStatus;
import com.lti.status.Status;
import com.lti.status.Status.StatusType;

@RestController
@CrossOrigin(origins =  "http://localhost:4200")
public class AccountDetailsController {

	@Autowired
	AccountDetailsServiceImpl accountDetailsService;

	@PostMapping(path = "/login")
	public LoginStatus login(@RequestBody AccountLogin accountLogin) {

		
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


	@PostMapping(path = "/netBanking")
	public Status netBanking(@RequestBody NetBanking netBanking) {
		
		try {
			accountDetailsService.setNetBankingPassword(netBanking);
			Status status = new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Password Changed Successfully!");
			return status;
		}
		catch(ServiceException e) {
			LoginStatus status = new LoginStatus();
			status.setStatus(StatusType.FAILED);
			status.setMessage(e.getMessage());
			return status;			
		}

	}

	
	@GetMapping(path="/getAccountDetails/{userId}")
	private AccountDetails viewAccountDetails(@PathVariable(value = "userId") String userId) {
		int intUserId = Integer.parseInt(userId);
		return accountDetailsService.getAccountDetails(intUserId);
		
	}


	@PostMapping(path="/forgetLoginPassword")
	private Status forgetPassword(@RequestBody ForgotLoginPasswordDTO forgotLoginPasswordDTO) {
		Status status = new Status();
		try {
		int userId = (int)Integer.parseInt(forgotLoginPasswordDTO.getUserId());
		accountDetailsService.resetPassword(userId,forgotLoginPasswordDTO.getLoginPassword());
		
		status.setStatus(StatusType.SUCCESS);
		status.setMessage("Password Change Successful");
		
		return status;
		}
		catch(ServiceException e) {
			
			status.setStatus(StatusType.FAILED);
			status.setMessage(e.getMessage());
			
			return status;
		}
	}
	
//	@PostMapping(path="/forgetUserId")
//	private Status forgetUserId(@RequestBody ForgotUserIdDTO forgotUserIdDTO) {
//		Status status = new Status();
//		try {
//		accountDetailsService.sendUserId(forgotUserIdDTO.getAccountNumber());
//		
//		status.setStatus(StatusType.SUCCESS);
//		status.setMessage("Password Change Successful");
//		
//		return status;
//		}
//		catch(ServiceException e) {
//			
//			status.setStatus(StatusType.FAILED);
//			status.setMessage(e.getMessage());
//			
//			return status;
//		}
//	}

	


}
