package com.lti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.services.TransactionServiceImpl;
import com.lti.dto.viewTransactionListDTO;
import com.lti.entities.Transaction;

@RestController
public class TransactionController {

	@Autowired
	private TransactionServiceImpl transactionServiceImpl; 
	
	
	@GetMapping(path="/viewTransactionList")
	private List<Transaction> viewTransactionList(@RequestBody viewTransactionListDTO object){
		
		return transactionServiceImpl.getAllTransactions(object.getAccountNumber());
	}
	
}
