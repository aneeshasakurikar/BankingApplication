package com.lti.services;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.daos.AccountDetailsDAO;
import com.lti.daos.UserDetailsDAO;
import com.lti.dto.AccountLogin;

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

	@Override
	public String checkUserStatus(int userId) {
		try {
			if()
			if(userDetailsDAO.getStatus(userId)) {
				return "Approved";
			}
			return "Waiting for admin approval";
		} catch (Exception e) {
			throw new ServiceException("Incorrect email/password");
		}

	}
}
