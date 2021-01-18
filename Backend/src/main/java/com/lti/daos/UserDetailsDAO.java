package com.lti.daos;

import java.util.List;

import com.lti.entities.UserDetails;

public interface UserDetailsDAO{

	UserDetails getUserDetailsByUserId(int userId);
	boolean isUserPresent(String aadharNumber);
	List<UserDetails> viewAllUsers();
	void updateUserStatus(String aadharNumber, Boolean adminApproval, String adminRemarks);
	boolean isUserApproved(int userId);
	public String getUserEmailByAadharNumber(String aadharNumber);
	int getAccountNumberByAadharNumber(String aadharNumber);
	void deleteUser(String aadharNumber);
	UserDetails save(UserDetails userDetails);
	int getUserId(String aadharNumber);
	boolean doesUserIdExists(int userId);
	
}
