package com.lti.services;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.daos.AccountDetailsDAO;
import com.lti.daos.UserDetailsDAO;
import com.lti.dto.AccountLogin;
import com.lti.dto.NetBanking;
import com.lti.entities.AccountDetails;

@Service
public class AccountDetailsServiceImpl implements AccountDetailsService {

	@Autowired
	AccountDetailsDAO accountDetailsDAO;
	
	@Autowired
	UserDetailsDAO userDetailsDAO;

	@Override
	public boolean loginUser(AccountLogin accountLogin) {

		try {
			if (!accountDetailsDAO.userExist(accountLogin.getUserId())) {
				throw new ServiceException("No such Account Exists");
			}
			int invalidAttempts = accountDetailsDAO.getInvalidAttempts(accountLogin.getUserId());
			boolean result = accountDetailsDAO.checkCredentials(accountLogin.getUserId(), accountLogin.getPassword());
			if (result) {
				accountDetailsDAO.setInvalidAttemptsZero(accountLogin.getUserId());
				return true;
			}

			if (invalidAttempts == 2) {
				throw new ServiceException("3 INVALID ATTEMPTS");
			}

			invalidAttempts = invalidAttempts + 1;
			throw new ServiceException("Incorrect email/password");

		} catch (Exception e) {
			throw new ServiceException("Incorrect email/password");
		}

	}



	public AccountDetails getAccountDetails(int userId) {
		
		return accountDetailsDAO.fetchAccountDetails(userId);
	}

public void resetPassword(int userId, String loginPassword) {
		
		try {
			accountDetailsDAO.updateLoginPassword(userId, loginPassword);
		
		}
		catch (Exception e) {
			System.out.println(e);
		}
	

	}

	public void setNetBankingPassword(NetBanking netBanking) {
		
		if(!accountDetailsDAO.userExist(netBanking.getUserId())) {
			throw new ServiceException("No such Account Exists");
		}
		if(!accountDetailsDAO.checkCredentials(netBanking.getUserId(),netBanking.getInitialLoginPassword())) {
			throw new ServiceException("Wrong Login Password");
		}
		if(!accountDetailsDAO.getTransactionPassword(accountDetailsDAO.getAccountNumber(netBanking.getUserId())).equalsIgnoreCase(netBanking.getInitialTransactionPassword())) {
			throw new ServiceException("Wrong Transaction Password");
		}
		
		accountDetailsDAO.updateLoginPassword(netBanking.getUserId(), netBanking.getFinalLoginPassword());
		accountDetailsDAO.updateTransactionPassword(netBanking.getUserId(), netBanking.getFinalTransactionPassword());
	
	}



//	public void sendUserId(int accountNumber) {
//		
//		accountDetailsDAO.
//		
//	}


}
