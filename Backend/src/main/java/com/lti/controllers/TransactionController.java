package com.lti.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.services.TransactionServiceImpl;

@RestController
public class TransactionController {

	@Autowired
	TransactionServiceImpl transactionServiceImpl; 
	
	@PostMapping(path="addTransaction")
	private void addTransaction() {
		
	}
	
	@GetMapping(path="/viewTransactionList")
	private void viewTransactionList(){
		
	}
	
}
