package com.softra.bankingapplication.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TransactionsDao extends JpaRepository<Transactions, Integer>{
	List<Transactions> findByAccountId(int accountId);
	
	@Modifying
	@Transactional
	@Query("SELECT t.transactionId FROM transactions t WHERE EXTRACT(MONTH from t.transDate) = :month")
	List<Integer> getAllByMonth(@Param("month") int month);
	
	@Modifying
	@Transactional
	@Query("SELECT t.transactionId FROM transactions t WHERE EXTRACT(YEAR from t.transDate) = :year")
	List<Integer> getAllByYear(int year);
}
