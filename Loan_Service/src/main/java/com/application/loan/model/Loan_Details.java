package com.application.loan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loanDetails")
public class Loan_Details {

	@Id
	private long accountNumber;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long loanId;
	
	@Column(name="loanAmount")
	private float loanAmount;
	
	@Column(name="loanDetails")
	private String loanDetails;

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public long getLoanId() {
		return loanId;
	}

	public void setLoanId(long loanId) {
		this.loanId = loanId;
	}

	public float getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(float loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getLoanDetails() {
		return loanDetails;
	}

	public void setLoanDetails(String loanDetails) {
		this.loanDetails = loanDetails;
	}
	
	
	
	
	

	

}
