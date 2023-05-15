package com.application.loan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.loan.model.Loan_Details;
import com.application.loan.repositorydao.LoanRepository;


@Service
public class LoanServiceImp implements LoanService {
	@Autowired
	LoanRepository userRepository;

	public void createUser(Loan_Details user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}

	
	public List<Loan_Details> getUser() {
		return userRepository.findAll();
	}

	public Loan_Details findById(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
		//return null;
	}


	public Loan_Details update(Loan_Details user, long l) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	
}
