package com.softra.bankingapplication.models;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softra.bankingapplication.exceptions.AccountNotFoundException;
import com.softra.bankingapplication.exceptions.InsufficientBalanceException;

@Service
public class FundTransferService {
	@Autowired
	private FundTransferDao ftDao;
	
	@Autowired
	private AccountDao accDao;
	
	@Autowired
	private TransactionsDao tDao;
	
	public List<FundTransfer> findAll() {
		return ftDao.findAll();
	}
	
	public FundTransfer save(FundTransfer ft) {
		return ftDao.save(ft);
	}
	
	public void transferFunds(int payerId, int payeeId, double amount) throws InsufficientBalanceException, AccountNotFoundException{
		Account payer = accDao.findById(payerId).get();
		Account payee = accDao.findById(payeeId).get();
		
		if(payer==null || payee==null) {
			AccountNotFoundException anfe = new AccountNotFoundException("Account not found");
			throw anfe;
		} else if (payer.getAccountBalance() <= 0 || payer.getAccountBalance() <= amount) {
			InsufficientBalanceException ibe = new InsufficientBalanceException("Insufficient balance");
			throw ibe;
		} else {
			double payerBal = payer.getAccountBalance() - amount;
			double payeeBal = payee.getAccountBalance() + amount;
			accDao.updateBalance(payerBal, payerId);
			accDao.updateBalance(payeeBal, payeeId);
			
			payer.setAccountBalance(payerBal);
			payee.setAccountBalance(payeeBal);
			
			Transactions transaction1 = new Transactions("From Payer", new Date(), "WITHDRAW", amount, payerId);
			Transactions transaction2 = new Transactions("To Payee", new Date(), "DEPOSIT", amount, payeeId);
			tDao.save(transaction1);
			tDao.save(transaction2);
			
			System.out.println("Payer: " + transaction1);
			System.out.println("Payee: " + transaction2);
			
			System.out.println("Payee's balance" + payer.getAccountBalance());
			System.out.println("Payee's balance" + payee.getAccountBalance());
		}
		
		
	}
}
