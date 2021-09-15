package com.softra.bankingapplication.models;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {
	
	@Modifying
	@Transactional
	@Query("UPDATE customers c set c.email = :first where c.userId= :second")
	public void updateEmail(@Param("first") String email, @Param("second") int userid);
	
	@Modifying
	@Transactional
	@Query("UPDATE customers c set c.address = :third where c.userId= :fourth")
	public void updateAddress(@Param("third") String address, @Param("fourth") int userid);
	
	@Modifying
	@Transactional
	@Query("UPDATE customers c set c.address = :fifth , c.email = :sixth where c.userId= :seventh")
	public void updateEmailAndAddress(@Param("fifth") String address, @Param("sixth") String email, @Param("seventh") int userid);
}
