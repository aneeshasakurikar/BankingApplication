package com.lti.services;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.lti.daos.AccountDetailsDAO;
import com.lti.daos.UserDetailsDAO;
import com.lti.dto.AccountLogin;
import com.lti.dto.NetBanking;
import com.lti.dto.SetNewPasswordDTO;
import com.lti.entities.AccountDetails;
import com.lti.entities.UserDetails;

@Service
public class AccountDetailsServiceImpl implements AccountDetailsService {

	@Autowired
	AccountDetailsDAO accountDetailsDAO;
	
	@Autowired
	UserDetailsDAO userDetailsDAO;
	
	@Autowired
	private MailSender emailSender;

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

//	public void setNetBankingPassword(NetBanking netBanking) {
//		
//		if(!accountDetailsDAO.userExist(netBanking.getUserId())) {
//			throw new ServiceException("No such Account Exists");
//		}
//		if(!accountDetailsDAO.checkCredentials(netBanking.getUserId(),netBanking.getInitialLoginPassword())) {
//			throw new ServiceException("Wrong Login Password");
//		}
//		if(!accountDetailsDAO.getTransactionPassword(accountDetailsDAO.getAccountNumber(netBanking.getUserId())).equalsIgnoreCase(netBanking.getInitialTransactionPassword())) {
//			throw new ServiceException("Wrong Transaction Password");
//		}
//		
//		accountDetailsDAO.updateLoginPassword(netBanking.getUserId(), netBanking.getFinalLoginPassword());
//		accountDetailsDAO.updateTransactionPassword(netBanking.getUserId(), netBanking.getFinalTransactionPassword());
//	
//	}


	@Override
	public void setNetBankingDetails(NetBanking netBanking) {
		if(!accountDetailsDAO.accountExists(netBanking.getAccountNumber())) {
			throw new ServiceException("Please enter valid Account Number");
		}
		if(accountDetailsDAO.firstRegistration(netBanking.getAccountNumber())!=null) {
			System.out.println("not 1st");
			throw new ServiceException("You have already registered for net Banking");
		}
		System.out.println("out of if");
		accountDetailsDAO.saveNewNetBanking(netBanking.getAccountNumber(), netBanking.getLoginPassword(), netBanking.getTransactionPassword());
		
		System.out.println("saved");
		int userId = accountDetailsDAO.getUserId(netBanking.getAccountNumber());
		String email = userDetailsDAO.getEmailByReferenceId(accountDetailsDAO.getReferenceId(netBanking.getAccountNumber()));
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("contact.ltibankingservices@gmail.com");
		message.setTo(email );
		message.setSubject("Net Banking Registration");		
		message.setText("You have successfully registered for Net Banking! Your userId is: "+userId+". ");
		emailSender.send(message);
		
		}


	@Override
	public UserDetails getUserById(int intUserId) {
		int referenceId = accountDetailsDAO.getReferenceIdByUserId(intUserId);
		return userDetailsDAO.getUserDetailsByReferenceId(referenceId);
	}



	public void setNewPassword(SetNewPasswordDTO newPass) {
		int intUserId = Integer.parseInt(newPass.getUserId());
		accountDetailsDAO.updateLoginPassword(intUserId, newPass.getLoginPassword());
		accountDetailsDAO.updateTransactionPassword(intUserId, newPass.getTransactionPassword());
		
	}
	



//	public void sendUserId(int accountNumber) {
//		
//		accountDetailsDAO.
//		
//	}


}
