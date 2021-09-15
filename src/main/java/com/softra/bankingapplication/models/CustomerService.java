package com.softra.bankingapplication.models;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	@Autowired
	private CustomerDao custdao;
	
	public CustomerService() {
	
	}

	public List<Customer> findAll() {
		return custdao.findAll();
	}
	
	public Customer findById(int id) {
		System.out.println("Inside findById of CustomerService");
		Optional<Customer> customer = custdao.findById(id);
		System.out.println(customer);
		return customer.get();
	}
	
	public Customer save(Customer cust) {
		return custdao.save(cust);
	}
	
	public void updateEmail(String email, int userid) {
		System.out.println("Inside updateEmail of CustomerService");
		custdao.updateEmail(email, userid);
	}
	
	public void updateAddress(String address, int userid) {
		System.out.println("Inside updateAddress of CustomerService");
		custdao.updateAddress(address, userid);
	}
	
	public void updateEmailAndAddress(String address, String email, int userid) {
		System.out.println("Inside CustomerService");
		custdao.updateEmailAndAddress(address, email, userid);
	}

}
