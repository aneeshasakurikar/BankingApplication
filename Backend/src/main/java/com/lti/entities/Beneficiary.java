package com.lti.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "beneficiary_table")
public class Beneficiary {

	@Id
	@GeneratedValue
	private int beneficiaryId;
	private int beneficiaryAccountNumber;
	private int userAccountNumber;

	@Column(length = 25)
	private String beneficiaryName;
	
	@Column(length = 10)
	private String beneficiaryNickName;

	public int getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(int beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public int getBeneficiaryAccountNumber() {
		return beneficiaryAccountNumber;
	}

	public void setBeneficiaryAccountNumber(int beneficiaryAccountNumber) {
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}

	public int getUserAccountNumber() {
		return userAccountNumber;
	}

	public void setUserAccountNumber(int userAccountNumber) {
		this.userAccountNumber = userAccountNumber;
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

}
