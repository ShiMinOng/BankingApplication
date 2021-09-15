package com.softra.bankingapplication.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name="customers")
public class Customer {
	@Id
	@Column(name = "user_id")
	private int userId;
	@Column(name="customer_name")
	private String customerName;
	@Column(name="email")
	private String email;
	@Column(name="address")
	private String address;
	
	public Customer() {}

	public Customer(int userId, String customerName, String email, String address) {
		super();
		this.userId = userId;
		this.customerName = customerName;
		this.email = email;
		this.address = address;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", customerName=" + customerName + ", email=" + email + ", address="
				+ address + "]";
	}
	
}
