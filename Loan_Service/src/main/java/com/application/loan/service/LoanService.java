package com.application.loan.service;

import java.util.List;

import com.application.loan.model.Loan_Details;

public interface LoanService {
	public void createUser(Loan_Details user);
	public List<Loan_Details> getUser() ;
	public Loan_Details findById(long account_number);	
	public Loan_Details update(Loan_Details user, long l);


	
}
