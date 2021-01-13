package com.lti.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.services.BeneficiaryServiceImpl;

@RestController
public class BeneficiaryController {

	//@Autowired
	BeneficiaryServiceImpl beneficiaryService;
	
	@PostMapping(path="/addBeneficiary")
	private void addBeneficiary() {
		
	}
	
	@GetMapping(path="/viewBeneficiaryList")
	private void viewBeneficiaryList(){
		
	}
}
