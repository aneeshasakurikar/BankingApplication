package com.lti.services;


import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.daos.UserDetailsDAO;
import com.lti.entities.UserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserDetailsDAO userDetailsDAO;
	
	@Override
	public int registerUser(UserDetails userDetails) {
		if(userDetailsDAO.isUserPresent(userDetails.getAadharNumber())) {
			throw new ServiceException("User already registered!");
		}
		else {
			UserDetails newUser = (UserDetails) userDetailsDAO.save(userDetails);
			
			return newUser.getUserId();
		}
	}

	@Override
	public UserDetails getUserById(int userId) {
		try {
				return userDetailsDAO.getUserDetailsByUserId(userId);
			}
			catch (NullPointerException e) {
				throw new ServiceException("");
			}
	}

	@Override
	public List<UserDetails> getAllUsers() {
		return userDetailsDAO.viewAllUsers();
	}

	@Override
	public void updateUserStatus(int userId) {
		
		
	}

}
