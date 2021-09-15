package com.softra.bankingapplication.models;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionsService {
	@Autowired
	private TransactionsDao transdao;
	
	public Transactions save(Transactions trans) {
		System.out.println("Inside save of UserService");
		return transdao.save(trans);
	}
	
	public List<Transactions> findAll() {
		System.out.println("Inside findAll of UserService");
		return transdao.findAll();
	}
	
	public Transactions findById(int id) {
		Optional<Transactions> trans = transdao.findById(id);
		return trans.get();
	}
	
	public List<Transactions> findAllTransactions(int accountId) {
		System.out.println("Inside getAllAccounts of AccountController");
		return transdao.findByAccountId(accountId);
	}
	
	public List<Integer> getAllByMonth(int month) {
		System.out.println(month);
		return transdao.getAllByMonth(month);
	}
	
	public List<Integer> getAllByYear(int year) {
		System.out.println(year);
		return transdao.getAllByYear(year);
	}
}
