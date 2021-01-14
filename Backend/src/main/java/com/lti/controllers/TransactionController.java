package com.lti.controllers;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.TransactionDTO;
import com.lti.services.TransactionServiceImpl;
import com.lti.status.Status;
import com.lti.status.Status.StatusType;

@RestController
public class TransactionController {

	//@Autowired
	TransactionServiceImpl transactionServiceImpl; 
	
	@PostMapping(path="addTransaction")
	private Status addTransaction(@RequestBody TransactionDTO transactionDTO) {
		try {
		transactionServiceImpl.transaction(transactionDTO);
		Status status = new Status();
		status.setMessage("Transaction Done");
		status.setStatus(StatusType.SUCCESS);;
		return status;
	}
	catch(ServiceException e) 
	{
		Status status = new Status();
		status.setMessage(e.getMessage());
		status.setStatus(StatusType.FAILED);
		return status;
	}
		
	}
	
	@GetMapping(path="/viewTransactionList")
	private void viewTransactionList(){
		
	}
	
}
