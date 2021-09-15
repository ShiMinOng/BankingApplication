package com.softra.bankingapplication.models;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softra.bankingapplication.exceptions.AccountNotFoundException;
import com.softra.bankingapplication.exceptions.OwnAccountException;

@Service
public class PayeeService {
	@Autowired
	private PayeeDao dao;
	
	@Autowired
	private AccountDao accDao;
	
	public List<Payee> findAll() {
		return dao.findAll();
	}
	
	public Payee save(Payee payee) throws OwnAccountException, AccountNotFoundException{
		boolean isSelf = false;
		boolean isAccount = false;
		List<Account> list = accDao.findAll();
		for(Account acc: list) {
			if(payee.getAccountId() == payee.getPayeeAccountID()) {
				isSelf = true;
			}
			if(acc.getAccountId() == payee.getPayeeAccountID()) {
				isAccount = true;
			}
		}
		if(isSelf == true ) {
			OwnAccountException oae = new OwnAccountException("you cannot add your own account");
			throw oae;
		}
		if(isAccount == false) {
			AccountNotFoundException anfe = new AccountNotFoundException("This account does not exist");
			throw anfe;
		}
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
