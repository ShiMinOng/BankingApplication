package com.softra.bankingapplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PayeeNotFoundException extends RuntimeException {
	public PayeeNotFoundException(String msg) {
		super(msg);
	}
}
