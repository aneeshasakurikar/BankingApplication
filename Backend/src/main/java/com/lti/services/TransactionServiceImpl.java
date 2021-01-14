package com.lti.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.daos.TransactionDAO;
import com.lti.entities.Transaction;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	TransactionDAO transactionDAO;
	
	public List<Transaction> getAllTransactions(int accountNumber) {
		
		return transactionDAO.getAllTransactions(accountNumber);
	}

}
