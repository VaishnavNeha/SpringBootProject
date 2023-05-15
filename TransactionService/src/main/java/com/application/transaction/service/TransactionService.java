package com.application.transaction.service;

import java.util.List;

import com.application.transaction.model.Transaction_Details;

public interface TransactionService {
	
	public Transaction_Details findByTransferFrom(long account_number);	
	public Transaction_Details updateMode(Transaction_Details user, String string);



	
}
