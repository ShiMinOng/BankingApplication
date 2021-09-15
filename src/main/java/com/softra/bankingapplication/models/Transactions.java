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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name = "transactions")
public class Transactions {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transaction_id")
	private int transactionId;
	
	@Column(name = "trans_description")
	private String description;
	
	@Column(name = "date_of_transaction")
	@Temporal(value = TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date transDate;
	
	@Column(name = "transaction_type")
	private String transType;
	
	@Column(name = "transamount")
	private double amount;
	
	@Column(name = "account_id")
	private int accountId;
	
	public Transactions() {
		super();
	}

	public Transactions(String description, Date transDate, String transType, double amount) {
		super();
		this.description = description;
		this.transDate = transDate;
		this.transType = transType;
		this.amount = amount;
	}

	public Transactions(String description, Date transDate, String transType, double amount, int accountId) {
		super();
		this.description = description;
		this.transDate = transDate;
		this.transType = transType;
		this.amount = amount;
		this.accountId = accountId;
	}

	public int getId() {
		return transactionId;
	}

//	public void setId(int transactionId) {
//		this.transactionId = transactionId;
//	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	public String getTrans_type() {
		return transType;
	}

	public void setTrans_type(String transType) {
		this.transType = transType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	@Override
	public String toString() {
		return "Transactions [id=" + transactionId + ", description=" + description + ", transDate=" + transDate
				+ ", transType=" + transType + ", amount=" + amount + ", accountId=" + accountId + "]";
	}

}
