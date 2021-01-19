package com.lti.services;

import com.lti.dto.AccountLogin;
import com.lti.dto.NetBanking;
import com.lti.entities.UserDetails;

public interface AccountDetailsService {

	boolean loginUser(AccountLogin accountLogin);
	//String checkUserStatus(int userId);

	void setNetBankingDetails(NetBanking netBanking);

	UserDetails getUserById(int intUserId);
	
}
