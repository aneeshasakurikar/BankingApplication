package com.lti.services;

import java.util.List;

import com.lti.dto.UpdateUserStatus;
import com.lti.entities.UserDetails;

public interface UserDetailsService {

	/*
	 * int registerUser(UserDetails userDetails); 
	 * void addUserStatus(CreateUserStatus
	 * status); 
	 * ViewUserDetails userDetails(int userId);
	 */
	
	public int registerUser(UserDetails user);
	//public UserDetails getUserById(int userId);
	public List<UserDetails> getAllUsers();
	void updateUserStatus(UpdateUserStatus status);
	//String getEmail(String aadharNumber);
	int getAccountNumber(String aadharNumber);
	String checkUserStatus(int userId);
}