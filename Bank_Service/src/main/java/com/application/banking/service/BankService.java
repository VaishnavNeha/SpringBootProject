package com.application.banking.service;

import java.util.List;

import com.application.banking.model.Bank_Account_Details;

public interface BankService {
	public void createUser(Bank_Account_Details user);
	public List<Bank_Account_Details> getUser() ;
	public Bank_Account_Details findById(long account_number);	
	public Bank_Account_Details update(Bank_Account_Details user, long l);


	
}
