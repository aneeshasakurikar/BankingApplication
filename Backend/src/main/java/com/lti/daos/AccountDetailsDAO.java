package com.lti.daos;

import com.lti.entities.AccountDetails;

public interface AccountDetailsDAO {

<<<<<<< HEAD
	void save(AccountDetails accountDetails);

	int getLastAccountNumber();

	long numOfUser();

	void saveAccountDetails(int accountNumber, int userId, String loginPassword, String transactionPassword);

	
=======
	boolean userExsit(int beneficiaryAccountnumber);

>>>>>>> 3645ace00adae235caba3f87c439fd0f4adb38cf
}
