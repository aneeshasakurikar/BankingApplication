package com.lti.daos;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.entities.Transaction;
import com.lti.entities.UserDetails;

@Repository
public class TransactionDAOImpl implements TransactionDAO {
	
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Transaction> getAllTransactions(int accountNumber) {
		List<Transaction> allTransactions = entityManager.createQuery("from Transaction t where t.payerAccountNumber=:accountNumber OR t.payeeAccountNumber=:accountNumber")
				.setParameter("accountNumber", accountNumber).getResultList();
		return allTransactions;
		
	}

}
