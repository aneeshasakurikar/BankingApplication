package com.lti.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class AccountDetails {

	@Id
	private int userId;
	private String loginPassword;
	private String transactionPassword;
	private String lastLogin;
	private int invalidAttempts;
	@OneToOne
	@JoinColumn
	private UserDetails accountNumber;
	
}
