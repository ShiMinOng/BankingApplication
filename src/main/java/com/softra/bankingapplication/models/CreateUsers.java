package com.softra.bankingapplication.models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Component
public class CreateUsers {
	
	public Map<String, Object> create1() {
		Map<String, Object> map = new HashMap<>();
		map.put("username", "Peh");
		map.put("loginPassword", "12345");
		map.put("secretQuestion", "Some Secret Question");
		map.put("transactionPassword", "12345");
		map.put("lockStatus", false);
		map.put("role", "ADMIN");
		return map;
	}
	
	public Map<String, Object> create2() {
		Map<String, Object> map = new HashMap<>();
		map.put("username", "John");
		map.put("loginPassword", "54321");
		map.put("secretQuestion", "What is your favourite Animal");
		map.put("transactionPassword", "54321");
		map.put("lockStatus", false);
		map.put("role", "CUSTOMER");
		map.put("customerName", "Johnny");
		map.put("email", "smth@gmail.com");
		map.put("address", "11 Springleaf Drive");
		map.put("accountType", "Savings");
		map.put("accountBalance", 500.00);
		return map;
	}
	
	public Map<String, Object> create3() {
		Map<String, Object> map = new HashMap<>();
		map.put("username", "James");
		map.put("loginPassword", "32121");
		map.put("secretQuestion", "What is your favourite Colour");
		map.put("transactionPassword", "32121");
		map.put("lockStatus", false);
		map.put("role", "CUSTOMER");
		map.put("customerName", "James");
		map.put("email", "everything@gmail.com");
		map.put("address", "31 Park Villas Rise");
		map.put("accountType", "Savings");
		map.put("accountBalance", 1000.00);
		return map;
	}
}
