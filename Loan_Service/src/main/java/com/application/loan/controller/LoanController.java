/**
 * 
 */
package com.application.loan.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.application.loan.model.Loan_Details;
import com.application.loan.service.LoanService;


@RestController
@RequestMapping("/loan")
public class LoanController {
	
	@Autowired
	LoanService loanService;
		/*
		 To Access from Zuul API Gateway
	 http://localhost:8989/loan/loanService/loan/loanDetails
*/
	

	@GetMapping(value = "/{loanDetails}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Loan_Details> getLoanDetailsById(@PathVariable("loan_number") long loan_number) {
        System.out.println("Fetching User with id " + loan_number);
        loanService.getUser();
        Loan_Details user = loanService.findById(loan_number);
        if (user == null) {
            return new ResponseEntity<Loan_Details>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Loan_Details>(user, HttpStatus.OK);
    }
    
	
	 @PutMapping(value="/update", headers="Accept=application/json")
		public ResponseEntity<String> updateLoanDetails(@RequestBody Loan_Details loan_Details)
		{
			System.out.println("sd");
			Loan_Details user = loanService.findById(loan_Details.getAccountNumber());
			if (user==null) {
				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			}
			loanService.update(loan_Details, loan_Details.getAccountNumber());
			return new ResponseEntity<String>(HttpStatus.OK);
		}
	


	

}
