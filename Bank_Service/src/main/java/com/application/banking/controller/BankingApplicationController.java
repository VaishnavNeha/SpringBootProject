/**
 * 
 */
package com.application.banking.controller;

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

import com.application.banking.model.Bank_Account_Details;
import com.application.banking.service.BankService;


@RestController
@RequestMapping("/account")
public class BankingApplicationController {
	
	@Autowired
	BankService bankService;
		/*
		 To Access from Zuul API Gateway
	 http://localhost:8989/banking/bankingService/account/createAccount
*/
	
	
	@GetMapping(value = "/{accountBalance}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Float> getUser(@PathVariable("account_number") long account_number) {
        System.out.println("Fetching User with id " + account_number);
        Bank_Account_Details user = bankService.findById(account_number);
        if (user == null) {
            return new ResponseEntity<Float>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Float>(user.getAccount_balance(), HttpStatus.OK);
    }
	
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bank_Account_Details> getUserById(@PathVariable("account_number") long account_number) {
        System.out.println("Fetching User with id " + account_number);
        bankService.getUser();
        Bank_Account_Details user = bankService.findById(account_number);
        if (user == null) {
            return new ResponseEntity<Bank_Account_Details>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Bank_Account_Details>(user, HttpStatus.OK);
    }
    
	 @PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<Void> createUser(@Valid @RequestBody Bank_Account_Details user, UriComponentsBuilder ucBuilder){
	     System.out.println("Creating User "+user.getAccountNumber());
	     bankService.createUser(user);
	     HttpHeaders headers = new HttpHeaders();
	     headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getAccountNumber()).toUri());
	     return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
	 
	 @PutMapping(value="/update", headers="Accept=application/json")
		public ResponseEntity<String> updateUser(@RequestBody Bank_Account_Details currentUser)
		{
			System.out.println("sd");
			Bank_Account_Details user = bankService.findById(currentUser.getAccountNumber());
			if (user==null) {
				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			}
			bankService.update(currentUser, currentUser.getAccountNumber());
			return new ResponseEntity<String>(HttpStatus.OK);
		}
	


	//Input
	/*
	 * id searchString
	 */
//Output
	/*
	 * Skill Matching skills array
	 */
//Note: If search string is empty retrieve all Skills

}
