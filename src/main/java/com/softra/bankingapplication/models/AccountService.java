package com.softra.bankingapplication.models;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountService {
	@Autowired
	private AccountDao acctdao;
	
	public List<Account> findAll() {
		return acctdao.findAll();
	}
	
	public Account save(Account account) {
		return acctdao.save(account);
	}
	
	public List<Account> findAllAccounts(int customerId) {
		System.out.println("Inside getAllAccounts of AccountController");
		return acctdao.findByCustomerId(customerId);
	}
	
	public Account findById(int id) {
		Optional<Account> acct = acctdao.findById(id);
		return acct.get();
	}
	
	public void updateBalance(double amount, int id) {
		acctdao.updateBalance(amount, id);
	}
	
	public int getAccountId(int customerid) {
		return acctdao.getAccountId(customerid);
	}
	
	public double getAccountBalance(int customerid) {
		return acctdao.getAccountBalance(customerid);
	}

}
