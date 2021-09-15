package com.softra.bankingapplication.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AccountDao extends JpaRepository<Account, Integer> {
	List<Account> findByCustomerId(int customerId);
	
	@Modifying
	@Transactional
	@Query("UPDATE accounts a SET a.accountBalance = :first WHERE a.accountId= :second")
	public void updateBalance(@Param("first") double accountBalance, @Param("second") int accountId);
	
	@Query("SELECT a.accountId FROM accounts a WHERE a.customerId = :third")
	public int getAccountId(@Param("third") int customerid);
	
	@Query("SELECT a.accountBalance FROM accounts a WHERE a.customerId = :fourth")
	public double getAccountBalance(@Param("fourth") int customerid);
}

