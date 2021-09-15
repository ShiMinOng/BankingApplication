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
import com.softra.bankingapplication.exceptions.InsufficientBalanceException;
import com.softra.bankingapplication.models.AccountService;
import com.softra.bankingapplication.models.FundTransfer;
import com.softra.bankingapplication.models.FundTransferService;

@RestController
@CrossOrigin("*")
public class FundTransferController {
	@Autowired
	private FundTransferService ftService;
	
	@Autowired
	private AccountService accService;	
	
	@GetMapping("/fundtransfer")
	public List<FundTransfer> getAll() {
		return ftService.findAll();
	}
	
	@PostMapping(path="/fundtransfer/{payerId}")
	public void transfer(@PathVariable("payerId") int payerId, @RequestBody Map<String, Object> requestBody) throws InsufficientBalanceException, AccountNotFoundException {
//		 System.out.println(requestBody);
		 int payeeId = Integer.parseInt(requestBody.get("payeeAccountId").toString());
		 Date date = new Date();
		 double amount = Double.parseDouble(requestBody.get("amount").toString());
		 FundTransfer ft = new FundTransfer(payerId,payeeId,date,amount);
		 ftService.transferFunds(payerId, payeeId, amount);
		 ftService.save(ft);
		 
	}
}
