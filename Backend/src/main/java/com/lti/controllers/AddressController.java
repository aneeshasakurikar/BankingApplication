package com.lti.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.services.AddressServiceImpl;

@RestController
public class AddressController {
	
	AddressServiceImpl addressServiceImpl;
	
	@PostMapping(path="/register")
	public void registerUser() {
		
	}
}
