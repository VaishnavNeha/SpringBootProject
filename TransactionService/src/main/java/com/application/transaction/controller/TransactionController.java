/**
 * 
 */
package com.application.transaction.controller;

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

import com.application.transaction.model.Transaction_Details;
import com.application.transaction.service.TransactionService;


@RestController
@RequestMapping("/tran")
public class TransactionController {
	
	@Autowired
	TransactionService bankService;
		/*
		 To Access from Zuul API Gateway
	 http://localhost:8989/transaction/transactionService/tran/getTransaction
*/
	
	
	@GetMapping(value = "/{getTransaction}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transaction_Details> getUser(@PathVariable("account_number") long account_number) {
        System.out.println("Fetching User with id " + account_number);
        Transaction_Details user = bankService.findByTransferFrom(account_number);
        if (user == null) {
            return new ResponseEntity<Transaction_Details>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Transaction_Details>(user, HttpStatus.OK);
    }
	
	
	 
	 @PutMapping(value="/updateMode", headers="Accept=application/json")
		public ResponseEntity<String> updateUser(@RequestBody Transaction_Details currentUser)
		{
			System.out.println("sd");
			Transaction_Details user = bankService.findByTransferFrom(currentUser.getAccount_transfer_from());
			if (user==null) {
				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			}
			bankService.updateMode(currentUser, currentUser.getMode());
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
