package com.lti.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.services.UserDetailsServiceImpl;

@RestController
public class UserDetailsController {

	@Autowired
	UserDetailsServiceImpl userDetailsService;
	
	@PostMapping(path="/register")
	public void registerUser() {
		
	}
	
	
}
