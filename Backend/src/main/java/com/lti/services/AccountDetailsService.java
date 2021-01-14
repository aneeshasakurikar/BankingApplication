package com.lti.services;

import com.lti.dto.AccountLogin;

public interface AccountDetailsService {

	boolean loginUser(AccountLogin accountLogin);
	//String checkUserStatus(int userId);
	
}
