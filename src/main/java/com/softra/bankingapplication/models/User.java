package com.softra.bankingapplication.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import javax.validation.constraints.Size;
//
//import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name="users")
public class User {
	@Id //primary key
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int userId;
	@Column(name="username")
	private String username;
	@Column(name="login_password")
	private String loginPassword;
	@Column(name="secret_question")
	private String secretQuestion;
	@Column(name="transaction_password")
	private String transactionPassword;
	@Column(name="lock_status")
	private boolean lockStatus;
	@Column(name="role")
	private String role;
	
	public User() {}

	public User(String username, String loginPassword, String secretQuestion, String transactionPassword,
			boolean lockStatus, String role) {
		super();
		this.username = username;
		this.loginPassword = loginPassword;
		this.secretQuestion = secretQuestion;
		this.transactionPassword = transactionPassword;
		this.lockStatus = lockStatus;
		this.role = role;
	}


	public int getUserId() {
		return userId;
	}

//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getSecretQuestion() {
		return secretQuestion;
	}

	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}

	public String getTransactionPassword() {
		return transactionPassword;
	}

	public void setTransactionPassword(String transactionPassword) {
		this.transactionPassword = transactionPassword;
	}

	public boolean getLockStatus() {
		return lockStatus;
	}

	public void setLockStatus(boolean lockStatus) {
		this.lockStatus = lockStatus;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", loginPassword=" + loginPassword + ", secretQuestion=" + secretQuestion
				+ ", transactionPassword=" + transactionPassword + ", lockStatus=" + lockStatus + ", role=" + role
				 + "]";
	}	
	
}
