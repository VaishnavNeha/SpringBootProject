package com.application.banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.banking.model.Bank_Account_Details;
import com.application.banking.repositorydao.BankRepository;


@Service
public class BankServiceImp implements BankService {
	@Autowired
	BankRepository userRepository;

	public void createUser(Bank_Account_Details user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}

	
	public List<Bank_Account_Details> getUser() {
		return userRepository.findAll();
	}

	public Bank_Account_Details findById(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
		//return null;
	}


	public Bank_Account_Details update(Bank_Account_Details user, long l) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}


}
