package com.lti.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "user_details_table")
//@NamedQuery(name="getAllUnapprovedUsers", query="from UserDetails ud where ud.status=0") 
//@NamedQuery(name="updateUserStatus", query="update UserDetails set status = :status, adminRemarks = :adminRemarks where aadharNumber = :aadharNumber ") 
@NamedQuery(name="checkIfUserApproved", query="select status from UserDetails where userId = :userId") 
@NamedQuery(name="getEmailByAadharNumber", query="select emailId from UserDetails where aadharNumber = :aadharNumber") 
//@NamedQuery(name="getAccountNumberByAadharNumber", query="select accountNumber from UserDetails where aadharNumber = :aadharNumber") 
//@NamedQuery(name="deleteUserByAadharNumber", query="delete from UserDetails where aadharNumber = :aadharNumber")
//@NamedQuery(name="getLastAccountNumber", query="select max(accountNumber) from UserDetails")
//@NamedQuery(name="getnumOfUsers", query="select count(*) from UserDetails")
@SequenceGenerator(name = "user_gen", sequenceName = "user_gen", initialValue = 10101)
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "user_gen")
	private int userId;
	
	//private int accountNumber;

	@Column(length = 5)
	private String title;

	@Column(length = 15)
	private String firstName;

	@Column(length = 15)
	private String middleName;

	@Column(length = 15)
	private String lastName;

	@Column(length = 15)
	private String fatherName;

	@Column(length = 10)
	private String mobileNumber;

	@Column(length = 35)
	private String emailId;

	@Column(length = 12)
	private String aadharNumber;
	private LocalDate dateOfBirth;

	@Column(length = 15)
	private String addressLine1;

	@Column(length = 15)
	private String addressLine2;

	@Column(length = 15)
	private String landmark;

	@Column(length = 15)
	private String state;

	@Column(length = 15)
	private String city;

	@Column(length = 6)
	private int pincode;
	
	@Column(length = 10)
	private String occupationType;

	@Column(length = 10)
	private String sourceOfIncome;
	private String annualIncome;
	private boolean status;
	private String adminRemarks;
	
//	public int getAccountNumber() {
//		return accountNumber;
//	}
//
//	public void setAccountNumber(int accountNumber) {
//		this.accountNumber = accountNumber;
//	}

	public boolean isStatus() {
		return status;
	}

	public String getAdminRemarks() {
		return adminRemarks;
	}

	public void setAdminRemarks(String adminRemarks) {
		this.adminRemarks = adminRemarks;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getOccupationType() {
		return occupationType;
	}

	public void setOccupationType(String occupationType) {
		this.occupationType = occupationType;
	}

	public String getSourceOfIncome() {
		return sourceOfIncome;
	}

	public void setSourceOfIncome(String sourceOfIncome) {
		this.sourceOfIncome = sourceOfIncome;
	}

	public String getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(String annualIncome) {
		this.annualIncome = annualIncome;
	}

}
