package com.application.transaction.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.transaction.model.Transaction_Details;
import com.application.transaction.repositorydao.TransactionRepository;


@Service
public class TransactionServiceImp implements TransactionService {
	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public Transaction_Details findByTransferFrom(long account_number) {
		// TODO Auto-generated method stub
		return transactionRepository.findById(account_number).get();
	}


	@Override
	public Transaction_Details updateMode(Transaction_Details user, String l) {
		// TODO Auto-generated method stub
		return transactionRepository.save(user);
	}

	
}
