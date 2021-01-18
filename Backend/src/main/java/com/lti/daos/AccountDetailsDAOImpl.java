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
	public boolean userExist(int userId) {
		System.out.println("dao user exist");
		return (Long) entityManager
				.createQuery("select count(ad.userId) from AccountDetails ad where ad.userId = :userId")
				.setParameter("userId", userId).getSingleResult() == 1 ? true : false;
	}

	@Override
	public int getInvalidAttempts(int userId) {
		System.out.println("dao got invalid");
		return (int) entityManager
				.createQuery("select ad.invalidAttempts from AccountDetails ad where ad.userId= :userId")
				.setParameter("userId", userId).getSingleResult();
	}

	@Override
	public boolean checkCredentials(int userId, String password) {
		System.out.println("dao check cred");
		return (Long) entityManager.createQuery(
				"select count(ad.userId) from AccountDetails ad where ad.userId=:userId and ad.loginPassword=:password")
				.setParameter("userId", userId).setParameter("password", password).getSingleResult() == 1 ? true
						: false;
	}

	@Override
	@Transactional
	public void setInvalidAttemptsZero(int userId) {
		System.out.println("dao set invalid");
		entityManager.createQuery("update AccountDetails set invalidAttempts=0 where userId= :userId")
				.setParameter("userId", userId).executeUpdate();
	}

	@Override
	public AccountDetails fetchAccountDetails(int userId) {
	
		return (AccountDetails) entityManager.createQuery(" from AccountDetails where userId=:userId")
				.setParameter("userId",userId).getSingleResult();
	}
	
	public String getTransactionPassword(int accountNumber) {
		
		return (String) entityManager.createQuery("select transactionPassword from AccountDetails where accountNumber = :accountNumber ")
				.setParameter("accountNumber", accountNumber).getSingleResult();
	}

	@Override
	public int getBalance(int fromAccount) {
		// TODO Auto-generated method stub
		return (int) entityManager.createQuery("select balance from AccountDetails where accountNumber = :fromAccount")
				.setParameter("fromAccount", fromAccount).getSingleResult();
	}

	@Override
	@Transactional
	public void updateBalance(int fromAccount, int curBalance) {
		// TODO Auto-generated method stub
		entityManager.createQuery("update AccountDetails set balance=:curBalance where accountNumber =: fromAccount")
		.setParameter("curBalance", curBalance).setParameter("fromAccount", fromAccount).executeUpdate();
		

	}
	
	@Override
	public boolean accountExists(int accountNumber) {
		return  (Long)entityManager
				.createQuery("select count(ad.accountNumber) from AccountDetails ad where ad.accountNumber = :accountNumber")
				.setParameter("accountNumber", accountNumber).getSingleResult() == 1 ? true : false;
	}

	@Override
	public int getAccountNumber(int userId) {
		System.out.println("1");
		return (int) entityManager.createQuery("select accountNumber from AccountDetails where userId=:userId").setParameter("userId", userId)
				.getSingleResult();
	}

	@Override
	@Transactional
	public void updateLoginPassword(int userId, String loginPassword) {
		
		entityManager.createQuery("update AccountDetails set loginPassword=:loginPassword where userId=:userId")
			.setParameter("loginPassword", loginPassword).setParameter("userId", userId).executeUpdate();
		
	}

	@Override
	@Transactional
	public void updateTransactionPassword(int userId, String initialTransactionPassword) {
		entityManager.createQuery("update AccountDetails set transactionPassword=:transactionPassword where userId=:userId")
		.setParameter("transactionPassword", initialTransactionPassword).setParameter("userId", userId).executeUpdate();
	}

}
