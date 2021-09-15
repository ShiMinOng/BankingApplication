package com.softra.bankingapplication.models;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	@Query("SELECT u from users u where u.username = :first and u.loginPassword = :second")
	public User findByUsernameAndPassword(@Param("first") String username, @Param("second") String password);
	
	@Modifying
	@Transactional
	@Query("UPDATE users u set u.loginPassword = :third where u.userId= :fourth")
	public void updatePassword(@Param("third") String password, @Param("fourth") int id);
}
