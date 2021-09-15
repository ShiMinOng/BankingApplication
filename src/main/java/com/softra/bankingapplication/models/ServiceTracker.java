package com.softra.bankingapplication.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name="serviceTracker")
public class ServiceTracker {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="service_id")
	private int serviceId;
	
	@Column(name="service_description")
	private String serviceDesc;
	
	@Column(name="service_raise_date")
	@Temporal(value = TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date serviceRaiseDate;
	
	@Column(name = "service_status")
	private String serviceStatus;
	
	@Column(name = "account_id")
	private int accountId;
	
	public ServiceTracker() {}


	public ServiceTracker(String serviceDesc, Date serviceRaiseDate, String serviceStatus, int accountId) {
		super();
		this.serviceDesc = serviceDesc;
		this.serviceRaiseDate = serviceRaiseDate;
		this.serviceStatus = serviceStatus;
		this.accountId = accountId;
	}

	public int getServiceId() {
		return serviceId;
	}

//	public void setServiceId(int id) {
//		this.serviceId = id;
//	}

	public String getServiceDesc() {
		return serviceDesc;
	}


	public void setServiceDesc(String serviceDesc) {
		this.serviceDesc = serviceDesc;
	}


	public Date getServiceRaiseDate() {
		return serviceRaiseDate;
	}


	public void setServiceRaiseDate(Date serviceRaiseDate) {
		this.serviceRaiseDate = serviceRaiseDate;
	}


	public String getServiceStatus() {
		return serviceStatus;
	}


	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}


	@Override
	public String toString() {
		return "ServiceTracker [serviceId=" + serviceId + ", serviceDesc=" + serviceDesc + ", serviceRaiseDate="
				+ serviceRaiseDate + ", serviceStatus=" + serviceStatus + ", accountId=" + accountId + "]";
	}
	
}
