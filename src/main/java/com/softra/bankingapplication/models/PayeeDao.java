package com.softra.bankingapplication.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PayeeDao extends JpaRepository<Payee, Integer> {
	@Query("SELECT p from payees p where p.accountId = :first")
	public List<Payee> findPayees(@Param("first") int accountId);
}
