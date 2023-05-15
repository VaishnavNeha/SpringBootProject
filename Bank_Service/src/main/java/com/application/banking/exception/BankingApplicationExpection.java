/**
 * 
 */
package com.application.banking.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BankingApplicationExpection extends Exception {
	
	@ExceptionHandler(BankingApplicationExpection.class)
	public void BankingException(String msg) {
		System.out.println(msg);
		
	}

}
