package com.lti.services;


import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.lti.daos.AccountDetailsDAO;
import com.lti.daos.UserDetailsDAO;
import com.lti.dto.UpdateUserStatus;
import com.lti.entities.AccountDetails;
import com.lti.entities.UserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserDetailsDAO userDetailsDAO;
	
	@Autowired
	AccountDetailsDAO accountDetailsDAO;
		
	@Autowired
	private MailSender emailSender;
	
	@Override
	public int registerUser(UserDetails userDetails) {
		System.out.println(userDetails.getAadharNumber());
		if(userDetailsDAO.isUserPresent(userDetails.getAadharNumber())) {
			throw new ServiceException("User already registered!");
		}
		else 
		{
//			int accountNumber;
//			if(accountDetailsDAO.numOfUser() == 0) {
//				accountNumber = 321001;
//			}
//			else {
//				accountNumber = accountDetailsDAO.getLastAccountNumber() + 1;
//			}
			
			userDetailsDAO.save(userDetails);
			
		}
		return userDetailsDAO.getReferenceId(userDetails.getAadharNumber());
	}
	
	@Override
	public List<UserDetails> getAllUsers() {
		return userDetailsDAO.viewAllUsers();
	}

	@Override
	public void updateUserStatus(UpdateUserStatus updatedStatus) {
		try {
			if(updatedStatus.isStatus()==true) {
				userDetailsDAO.updateUserStatus(updatedStatus.getAadharNumber(), updatedStatus.isStatus(), updatedStatus.getAdminRemarks());
				SimpleMailMessage message = new SimpleMailMessage();
				message.setFrom("contact.ltibankingservices@gmail.com");
				message.setTo( userDetailsDAO.getUserEmailByAadharNumber(updatedStatus.getAadharNumber()));
				message.setSubject("Application Approved");
				int accountNumber;
				int userId;
				if(accountDetailsDAO.numOfUser()==0) {
					accountNumber = 5005001;
					userId = 123001;
				}
				else {
					accountNumber = accountDetailsDAO.getLastAccountNumber()+1;
					userId = accountDetailsDAO.getLastUserId()+1;
				}
				
//				String loginChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
//				String transactionChar = "1234567890";
//				String loginPassword = RandomStringUtils.random( 15, loginChar);
//				String transactionPassword = RandomStringUtils.random( 4, transactionChar);
				accountDetailsDAO.saveAccountDetails(accountNumber, userId, userDetailsDAO.getReferenceId(updatedStatus.getAadharNumber()));
				
				message.setText("Your Application to open an account at our bank is accepted. Your Account Number is: "+accountNumber+". "
						+ "You can Register for net Banking using your account Number, post which you'll get your userId.");
				emailSender.send(message);
			}
			else {
				SimpleMailMessage message = new SimpleMailMessage();
				message.setFrom("contact.ltibankingservices@gmail.com");
				message.setTo( userDetailsDAO.getUserEmailByAadharNumber(updatedStatus.getAadharNumber()));
				//message.setSubject("Application Approved");
				message.setSubject("Application Rejected");				
				message.setText("Your Application to open an account at our bank is rejected. Please try again with valid details");
				System.out.println("abt to send mail");
				emailSender.send(message);
				System.out.println("msg sent");
				userDetailsDAO.deleteUser(updatedStatus.getAadharNumber());
				
			}
			
			
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	@Override
	public String checkUserStatus(int referenceId) {
		
		if(!userDetailsDAO.doesReferenceIdExists(referenceId)) {
			throw new ServiceException("no such ReferenceId exists");
		}
		if(userDetailsDAO.isUserApproved(referenceId))
			return "approved";
		return "waiting for approval";
	}
	
//	@Override
//	public UserDetails getUserById(int userId) {
//		try {
//				return userDetailsDAO.getUserDetailsByUserId(userId);
//			}
//			catch (NullPointerException e) {
//				throw new ServiceException("");
//			}
//	}

//	@Override
//	public String getEmail(String aadharNumber) {
//		try {
//			return userDetailsDAO.getUserEmailByAadharNumber(aadharNumber);
//		}
//		catch(Exception e) {
//			throw new ServiceException("Error !!!");
//		}
//		
//	}

	@Override
	public int getAccountNumber(String aadharNumber) {
		try {
			return userDetailsDAO.getAccountNumberByAadharNumber(aadharNumber);
		}
		catch(Exception e) {
			throw new ServiceException("Error !!!");
		}
	}
	
	



}
