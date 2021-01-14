package com.lti.services;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import com.lti.daos.AccountDetailsDAO;
import com.lti.daos.BeneficiaryDAO;
import com.lti.daos.TransactionDAO;
import com.lti.daos.UserDetailsDAO;
import com.lti.dto.TransactionDTO;
import com.lti.entities.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.daos.TransactionDAO;
import com.lti.entities.Transaction;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	TransactionDAO transactionDAO;
	@Autowired
	UserDetailsDAO userdetailsDAO;
	@Autowired
	BeneficiaryDAO beneficiaryDAO;
	@Autowired
	AccountDetailsDAO accountdetailsDAO;
	
	public List<Transaction> getAllTransactions(int accountNumber) {
		
		return transactionDAO.getAllTransactions(accountNumber);
	}

	
	@Override
	public void transaction(TransactionDTO transactionDetails) {
		// TODO Auto-generated method stub
		Transaction transaction = new Transaction();
		String actualTnPassword =  accountdetailsDAO.getTransactionPassword(transactionDetails.getFromAccount());
		System.out.println(transactionDetails.getTransactionPassword());
		if(!actualTnPassword.equals(transactionDetails.getTransactionPassword())) {
			throw new ServiceException("Invalid Transaction Password");
		}
		if(!beneficiaryDAO.userExsit(transactionDetails.getFromAccount(),transactionDetails.getToAccount())) {
			throw new ServiceException("Benificiary not Found");
		}
		if(transactionDetails.getAmount()<=0) {
			throw new ServiceException("Enter Valid Transaction Ammount");
		}
		WithdrawBalance(transactionDetails.getFromAccount(),transactionDetails.getAmount());
		DepositBalance(transactionDetails.getToAccount(),transactionDetails.getAmount());
		
		transaction.setPayerAccountNumber(transactionDetails.getFromAccount());
		transaction.setPayeeAccountNumber(transactionDetails.getToAccount());
		transaction.setTransactionMode(transactionDetails.getTransactionMode());
		transaction.setAmount(transactionDetails.getAmount());
		
		//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		LocalDate now = LocalDate.now();
		
		transaction.setDateOfTransaction(now);
	}
	private void DepositBalance(int toAccount, int amount) {
		// TODO Auto-generated method stub
		int curBalance=accountdetailsDAO.getBalance(toAccount);
		curBalance+=amount;
		accountdetailsDAO.updateBalance(toAccount, curBalance);

    }
	public void WithdrawBalance(int fromAccount, int amount) {
		// TODO Auto-generated method stub
		int curBalance=accountdetailsDAO.getBalance(fromAccount);
		if(curBalance<amount) {
			throw new ServiceException("Insufficient Funds");
		}
		curBalance-=amount;
		accountdetailsDAO.updateBalance(fromAccount, curBalance);
	}
}
