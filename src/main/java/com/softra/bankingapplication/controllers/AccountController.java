package com.softra.bankingapplication.controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.softra.bankingapplication.exceptions.AccountNotFoundException;
import com.softra.bankingapplication.models.Account;
import com.softra.bankingapplication.models.AccountService;

@RestController
@CrossOrigin("*")
public class AccountController {
	@Autowired
	private AccountService service;
	
	@GetMapping("/accounts")
	public List<Account> getAllAccounts() {
		return service.findAll();
	}
	
//	@GetMapping(path="/accounts/{id}")
//	public List<Account> getAllAccounts(@PathVariable("id") int customerId) throws AccountNotFoundException {
//		System.out.println("Inside getAllAccounts of AccountController");
//		List<Account> acclist = service.findAllAccounts(customerId);
//		if(acclist.isEmpty()) {
//			System.out.println("AccountController not found...");
//			AccountNotFoundException anfe = new AccountNotFoundException("Account with Customer ID: "+customerId+" is not found");
//			throw anfe;
//		}
//		return acclist;
//	}
	
	@GetMapping(path="/accounts/{id}")
	public double getAccountBalance(@PathVariable("id") int customerId) {
		System.out.println("Inside getAccount of AccountController");
		return service.getAccountBalance(customerId);
	}
	
	@PostMapping("/accounts")
	public Account createAccount(@RequestBody Map<String, Object> beforeMap) {
		String type = beforeMap.get("accountType").toString();
		double balance = (double) beforeMap.get("accountBalance");
		int customerId = (int) beforeMap.get("customerId");;
		Date date = new Date();
		Account acct = new Account(type, balance, date, customerId);
		return service.save(acct);
	}
	
	@GetMapping(path="/accounts/user/{id}")
	//List<Integer>
	public int getAccountIds(@PathVariable("id") int customerId) {
		System.out.println("Inside getAccountIds of Account Controller");
		return service.getAccountId(customerId);
	}
	
}
