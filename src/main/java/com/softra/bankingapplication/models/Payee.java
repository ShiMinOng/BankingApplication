package com.softra.bankingapplication.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity(name = "payees")

public class Payee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="payee_id")
	private int payeeId;
	
	@Column(name = "account_id")
	private int accountId;
	
	@Column(name="payee_account_id")
	private int payeeAccountID;
	
	@Column(name = "nickname")
	private String nickname;


	public Payee() {
		
	}

	public Payee(int accountId, int payeeAccountID, String nickname) {
		super();
		this.accountId = accountId;
		this.payeeAccountID = payeeAccountID;
		this.nickname = nickname;
	}
	
	

	public int getPayeeId() {
		return payeeId;
	}

//	public void setPayeeId(int payeeId) {
//		this.payeeId = payeeId;
//	}

	public int getAccountId() {
		return accountId;
	}


	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}


	public int getPayeeAccountID() {
		return payeeAccountID;
	}


	public void setPayeeAccountID(int payeeAccountID) {
		this.payeeAccountID = payeeAccountID;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "Payee [accountId=" + accountId + ", payeeAccountID=" + payeeAccountID + ", nickname=" + nickname + "]";
	}	

} // 
