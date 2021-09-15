package com.softra.bankingapplication.controllers;

import java.util.ArrayList;
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

import com.softra.bankingapplication.models.TransactionsService;
import com.softra.bankingapplication.exceptions.AccountNotFoundException;
import com.softra.bankingapplication.models.Transactions;

@RestController
@CrossOrigin("*")
public class TransactionsController {
	@Autowired
	private TransactionsService transservice;
	
	@GetMapping(path="/transactions")
	public List<Transactions> retrieveAllTransactions() {
		System.out.println("Inside retrieveAllTransactions of TransactionController");
		return transservice.findAll();
	}
	
	@PostMapping("/transactions")
	public Transactions createTransaction(@RequestBody Map<String, Object> beforeMap) {
		String description = beforeMap.get("description").toString();
		Date date = new Date();
		String transType = beforeMap.get("transType").toString();
		double amount = (double)beforeMap.get("amount");
		int accountId = (int)beforeMap.get("accountId");
		Transactions transaction = new Transactions(description,date,transType,amount,accountId);
		return transservice.save(transaction);
	}
	
	@GetMapping("/transactions/accounts/{id}")
	public List<Transactions> getAccountDetails(@PathVariable("id") int accountId) throws AccountNotFoundException {
		List<Transactions> translist = transservice.findAllTransactions(accountId);
		if(translist.isEmpty()) {
			System.out.println("AccountController not found...");
			AccountNotFoundException anfe = new AccountNotFoundException("Transactions with Account ID: "+accountId+" is not found");
			throw anfe;
		}
		return translist;
	}
	
	
	@GetMapping(path="/transactions/month/{month}")
	public List<Transactions> getAllTransactionsByMonth(@PathVariable("month") int month) {
		List<Integer> idList = transservice.getAllByMonth(month);
		List<Transactions> tList = new ArrayList<>();
		for(int id:idList) {
			tList.add(transservice.findById(id));
		}
		return tList;
	}
	
	@GetMapping(path="/transactions/year/{year}")
	public List<Transactions> getAllTransactionsByYear(@PathVariable("year") int year){
		List<Integer> idList = transservice.getAllByYear(year);
		List<Transactions> tList = new ArrayList<>();
		for(int id:idList) {
			tList.add(transservice.findById(id));
		}
		return tList;
	}
	
}
