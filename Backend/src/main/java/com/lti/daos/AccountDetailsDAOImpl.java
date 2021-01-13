package com.lti.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entities.AccountDetails;

@Repository
public class AccountDetailsDAOImpl implements AccountDetailsDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void save(AccountDetails accountDetails) {
		entityManager.persist(accountDetails);
	}
	
	@Override
	public int getLastAccountNumber() {
		return (int) entityManager.createQuery("select max(ad.accountNumber) from AccountDetails ad").getSingleResult();
	}

	
	@Override
	public long numOfUser() {
		return (long) entityManager.createQuery("select count(*) from AccountDetails").getSingleResult();
	}

	@Override
	@Transactional
	public void saveAccountDetails(int accountNumber, int userId, String loginPassword, String transactionPassword) {
		AccountDetails accountDetails = new AccountDetails();
		System.out.println("obj created");
		accountDetails.setAccountNumber(accountNumber);
		System.out.println("acc num set");
		accountDetails.setUserId(userId);
		System.out.println("user id set");
		accountDetails.setLoginPassword(loginPassword);
		System.out.println("pass set1");
		accountDetails.setTransactionPassword(transactionPassword);
		System.out.println("pass set2");
		entityManager.merge(accountDetails);
		System.out.println("merged");
	}

	@Override
	public boolean userExsit(int beneficiaryAccountnumber) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
