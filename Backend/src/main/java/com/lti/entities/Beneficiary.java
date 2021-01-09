package com.lti.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Beneficiary {
	
	@Id
	@GeneratedValue
	private int beneficiaryId;
	private int beneficiaryAccountNumber;
	private String beneficiaryName;
	private String beneficiaryNickName;
	private String userAccountNumber;

	public int getBeneficiaryAccountNumber() {
		return beneficiaryAccountNumber;
	}

	public void setBeneficiaryAccountNumber(int beneficiaryAccountNumber) {
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}

	public int getBeneficiaryId() {
		return beneficiaryId;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public String getBeneficiaryNickName() {
		return beneficiaryNickName;
	}

	public void setBeneficiaryNickName(String beneficiaryNickName) {
		this.beneficiaryNickName = beneficiaryNickName;
	}

	public String getUserAccountNumber() {
		return userAccountNumber;
	}

	public void setUserAccountNumber(String userAccountNumber) {
		this.userAccountNumber = userAccountNumber;
	}

}
