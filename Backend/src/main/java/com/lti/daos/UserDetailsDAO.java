package com.lti.daos;

import java.util.List;

import com.lti.entities.UserDetails;

public interface UserDetailsDAO{

	UserDetails save(UserDetails user);
	UserDetails getUserDetailsByUserId(int userId);
	boolean isUserPresent(int userId);
	List<UserDetails> viewAllUsers();
	void updateUserStatus(int userId, Boolean adminApproval, String adminRemarks);
	boolean isUserApproved(int userId);
	
}
