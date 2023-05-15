/**
 * 
 */
package com.application.transaction.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TransactionExpection extends Exception {
	
	@ExceptionHandler(TransactionExpection.class)
	public void TransactionException(String msg) {
		System.out.println(msg);
		
	}

}
