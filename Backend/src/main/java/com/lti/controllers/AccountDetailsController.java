package com.lti.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.services.AccountDetailsServiceImpl;

@RestController
public class AccountDetailsController {

	//@Autowired
	AccountDetailsServiceImpl accountDetailsService;
	
	@PostMapping(path="/login")
	private void login() {
		
	}
	
	@PostMapping(path="/forgotUserId")
	private void forgotUserId() {
		
	}
	
	@PostMapping(path="/forgotLoginPassword")
	private void forgotPassword() {
		
	}
	
	@PostMapping(path="/forgotTransactionPassword")
	private void forgotTransactionPassword() {
		
	}
		
}
