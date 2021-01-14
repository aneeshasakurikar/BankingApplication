package com.lti.daos;

import com.lti.entities.AccountDetails;

public interface AccountDetailsDAO {

	void save(AccountDetails accountDetails);

	int getLastAccountNumber();

	long numOfUser();

	void saveAccountDetails(int accountNumber, int userId, String loginPassword, String transactionPassword);

	
	boolean userExist(int beneficiaryAccountnumber);

	int getInvalidAttempts(int userId);

	boolean checkCredentials(int userId, String password);

	void setInvalidAttemptsZero(int userId);


}
