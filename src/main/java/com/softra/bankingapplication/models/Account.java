package com.softra.bankingapplication.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name="accounts")
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "account_id")
	private int accountId;
	
	@Column(name="account_type")
	private String accountType;
	
	@Column(name="account_balance")
	private double accountBalance;
	
	@Column(name="open_date")
	@Temporal(value=TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date openDate;
	
	@Column(name="customer_id")
	private int customerId;

	
	public Account() {}
	public Account(String accountType, double accountBalance, Date openDate) {
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.openDate = openDate;
	}
	
	public Account(String accountType, double accountBalance, Date openDate, int customerId) {
		super();
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.openDate = openDate;
		this.customerId = customerId;
	}
	
	public int getAccountId() {
		return accountId;
	}
	
//	public void setAccountId(int accountId) {
//		this.accountId = accountId;
//	}
	
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	@Override
	public String toString() {
		return "AccountMaster [accountId=" + accountId + ", accountType=" + accountType + ", accountBalance="
				+ accountBalance + ", openDate=" + openDate + ", customerId=" + customerId + "]";
	}	
	
}
