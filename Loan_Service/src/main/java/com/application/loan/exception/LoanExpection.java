/**
 * 
 */
package com.application.loan.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LoanExpection extends Exception {
	
	@ExceptionHandler(LoanExpection.class)
	public void LoanException(String msg) {
		System.out.println(msg);
		
	}

}
