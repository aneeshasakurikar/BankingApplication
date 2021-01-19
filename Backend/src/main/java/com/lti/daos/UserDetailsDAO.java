package com.lti.daos;

import java.util.List;

import com.lti.entities.UserDetails;

public interface UserDetailsDAO{

	boolean isUserPresent(String aadharNumber);
	List<UserDetails> viewAllUsers();
	void updateUserStatus(String aadharNumber, Boolean adminApproval, String adminRemarks);
	boolean isUserApproved(int referenceId);
	public String getUserEmailByAadharNumber(String aadharNumber);
	int getAccountNumberByAadharNumber(String aadharNumber);
	void deleteUser(String aadharNumber);
	UserDetails save(UserDetails userDetails);
	int getReferenceId(String aadharNumber);
	boolean doesReferenceIdExists(int userId);
	String getEmailByReferenceId(int referenceId);
	UserDetails getUserDetailsByReferenceId(int referenceId);
	
}
