package com.softra.bankingapplication.models;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayeeService {
	@Autowired
	private PayeeDao dao;
	
	public List<Payee> findAll() {
		return dao.findAll();
	}
	
	public Payee save(Payee payee) {
		return dao.save(payee);
	}
	
	public Payee findById(int id) {
		Optional<Payee> payee = dao.findById(id);
		return payee.get();
	}
	
	public List<Payee> findPayees(int payerAccountId) {
		return dao.findPayees(payerAccountId);
	}
}
