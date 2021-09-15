package com.softra.bankingapplication.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "fundTransfers")
public class FundTransfer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="fund_transfer_id")
	private int fundTransferId;
	
	@Column(name = "account_id")
	private int accountId;
	
	@Column(name = "payee_account_id")
	private int payeeAccountId;
	
	@Column(name = "date_of_transfer")
	private Date dateOfTransfer;
	
	@Column(name = "transfer_amount")
	private double transferAmount;	

	public FundTransfer() {
		
	}

	public FundTransfer(int accountId, int payeeAccountId, Date dateOfTransfer, double transferAmount) {
		super();
		this.accountId = accountId;
		this.payeeAccountId = payeeAccountId;
		this.dateOfTransfer = dateOfTransfer;
		this.transferAmount = transferAmount;
	}

	public int getFundTransferId() {
		return fundTransferId;
	}

//	public void setFundTransferId(int fundTransferId) {
//		this.fundTransferId = fundTransferId;
//	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getPayeeAccountId() {
		return payeeAccountId;
	}

	public void setPayeeAccountId(int payeeAccountId) {
		this.payeeAccountId = payeeAccountId;
	}

	public Date getDateOfTransfer() {
		return dateOfTransfer;
	}

	public void setDateOfTransfer(Date dateOfTransfer) {
		this.dateOfTransfer = dateOfTransfer;
	}

	public double getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(double transferAmount) {
		this.transferAmount = transferAmount;
	}

	@Override
	public String toString() {
		return "FundTransfer [fundTransferId=" + fundTransferId + ", accountId=" + accountId + ", payeeAccountId="
				+ payeeAccountId + ", dateOfTransfer=" + dateOfTransfer + ", transferAmount=" + transferAmount + "]";
	}

}
