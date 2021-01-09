package com.lti.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="account_details_table")
@SequenceGenerator(name = "account_gen", sequenceName = "account_gen",  initialValue = 123000)
public class AccountDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "account_gen")
	private int accountNumber ;
	
	private String loginPassword;
	private String transactionPassword;
	private String lastLogin;
	private int invalidAttempts;
	
	@OneToOne
	private Beneficiary beneficiary;
	
	
	
//	@OneToOne
//	@JoinColumn
//	private UserDetails accountNumber;
	
}
