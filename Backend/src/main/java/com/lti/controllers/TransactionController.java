package com.lti.controllers;


import java.util.List;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.TransactionDTO;
import com.lti.services.TransactionServiceImpl;
import com.lti.dto.viewTransactionListDTO;
import com.lti.entities.Transaction;
import com.lti.status.Status;
import com.lti.status.Status.StatusType;


@RestController
@CrossOrigin(origins =  "http://localhost:4200")
public class TransactionController {

	@Autowired
	private TransactionServiceImpl transactionServiceImpl; 
	


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
	
	@GetMapping(path="/viewTransactionList/{userId}")
	private List<Transaction> viewTransactionList(@PathVariable(value="userId") String userId){
		int intuserId = Integer.parseInt(userId);
		return transactionServiceImpl.getAllTransactions(intuserId);
	}
	
}
