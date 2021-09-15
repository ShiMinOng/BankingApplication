package com.softra.bankingapplication.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FundTransferDao extends JpaRepository<FundTransfer, Integer> {
	
}
