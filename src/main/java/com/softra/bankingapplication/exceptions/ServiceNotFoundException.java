package com.softra.bankingapplication.exceptions;

//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ServiceNotFoundException extends RuntimeException {
	public ServiceNotFoundException(String msg) {
		super(msg);
	}
}
