package com.softra.bankingapplication.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.softra.bankingapplication.exceptions.AccountNotFoundException;
import com.softra.bankingapplication.models.Account;
import com.softra.bankingapplication.models.Customer;
import com.softra.bankingapplication.models.CustomerService;

@RestController
@CrossOrigin("*")
public class CustomerController {

	@Autowired
	private CustomerService custservice;
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() throws AccountNotFoundException {
		System.out.println("Inside getAllCustomers of Customer Controller");
		List<Customer> custlist = custservice.findAll();
		if(custlist.isEmpty()) {
			System.out.println("Customer list is empty exception");
			AccountNotFoundException anfe = new AccountNotFoundException("There are no customers available in the list");
			throw anfe; //for frontend to catch
		}
		return custlist;
	}
	
	@GetMapping(path="/customers/{id}")
	public Customer findById(@PathVariable int id) {
		System.out.println(id);
		return custservice.findById(id);
	}
	
	@PostMapping(path = "/customers")
	public Customer createCustomer(@RequestBody Customer customer) {   
		System.out.println("Inside createCustomer post of CustomerControleer ");
		return custservice.save(customer);	
	}
	
	//NOT FULLY DONE YET (MIGHT HAVE COMPLICATIONS ON FRONTEND)
	@PutMapping(path="/customers/{id}")
	public void changeCommunication(@RequestBody Map<String, Object> body, @PathVariable("id") int userid) {
		String radioBox = body.get("radioBox").toString(); //radiobox on frontend
		System.out.println(body);
		if (radioBox.equals("one")) {
			String address = body.get("address").toString();
			String email = body.get("email").toString();
			System.out.println("Address: " + address + " " + "Email: " + email);
			custservice.updateEmailAndAddress(address, email, userid);
			
		} else if (radioBox.equals("two")) {
			String address = body.get("address").toString();
			System.out.println("Address: " + address);
			custservice.updateAddress(address, userid);
			
		} else if (radioBox.equals("three")) {
			String email = body.get("email").toString();
			System.out.println("Email: " + email);
			custservice.updateEmail(email, userid);
		}
		System.out.println("Address and/or email successfully updated");
	}
	
	
}
