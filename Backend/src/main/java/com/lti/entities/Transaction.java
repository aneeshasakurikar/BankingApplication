package com.lti.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "transaction_gen", sequenceName = "transaction_gen",  initialValue = 1000000)
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "transaction_gen")
	private int transactionId;
	private int payerAccountNumber;
	private int payeeAccountNumber;
	private String mode;
	private int amount;
	private LocalDate dateOfTransaction;
	private String remarks;

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public int getPayerAccountNumber() {
		return payerAccountNumber;
	}

	public void setPayerAccountNumber(int payerAccountNumber) {
		this.payerAccountNumber = payerAccountNumber;
	}

	public int getPayeeAccountNumber() {
		return payeeAccountNumber;
	}

	public void setPayeeAccountNumber(int payeeAccountNumber) {
		this.payeeAccountNumber = payeeAccountNumber;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public LocalDate getDateOfTransaction() {
		return dateOfTransaction;
	}

	public void setDateOfTransaction(LocalDate dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}

}
