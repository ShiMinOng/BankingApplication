package com.softra.bankingapplication.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.softra.bankingapplication.exceptions.AccountNotFoundException;
import com.softra.bankingapplication.exceptions.UserNotFoundException;
import com.softra.bankingapplication.models.Account;
import com.softra.bankingapplication.models.AccountService;
import com.softra.bankingapplication.models.Customer;
import com.softra.bankingapplication.models.CustomerService;
import com.softra.bankingapplication.models.User;
import com.softra.bankingapplication.models.UserService;

@RestController
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserService userservice;
	@Autowired
	private CustomerService custservice;
	@Autowired
	private AccountService acctservice;
	
	public UserController() {
		System.out.println("Inside default constructor of User Controller");
	}
	
	@PostMapping(path="/users")
	public User createAccount(@RequestBody Map<String, Object> beforeMap) {
		String username = beforeMap.get("username").toString();
		String password = beforeMap.get("loginPassword").toString();
		String question = beforeMap.get("secretQuestion").toString();
		String transpassword = beforeMap.get("transactionPassword").toString();
		boolean lockStatus = (boolean) beforeMap.get("lockStatus");
		String role = beforeMap.get("role").toString();
		User user = new User(username, password, question, transpassword, lockStatus, role);
		userservice.save(user);
		
		if (!role.equals("ADMIN")) { //radiobox on frontend
			int userid = user.getUserId();
			String name = beforeMap.get("customerName").toString();
			String email = beforeMap.get("email").toString();
			String address = beforeMap.get("address").toString();
			Customer cust = new Customer(userid, name, email, address);
			custservice.save(cust);
			
			String type = beforeMap.get("accountType").toString();
			double balance = Double.parseDouble(beforeMap.get("accountBalance").toString());
			int customerId = user.getUserId();
			Date date = new Date();
			Account acct = new Account(type, balance, date, customerId);
			acctservice.save(acct);
		}
		
		System.out.println("Inside postUser of UserController");
		
		
		return user;
	}
	
	@PostMapping(path="/login")
	public Map<String, Object> getLogin(@RequestBody Map<String, Object> tgt) throws UserNotFoundException {
		String username = tgt.get("username").toString();
		String password = tgt.get("loginPassword").toString();
		System.out.println("Inside getLogin");
		User userrr = userservice.findByUsernameAndPassword(username, password);
		if (userrr == null) {
			throw new UserNotFoundException("User not found");
		}
		Map<String, Object> map = new HashMap<>();
		map.put("userId", userrr.getUserId());
		map.put("role", userrr.getRole());
		return map;
	}
	
	@PutMapping(path="/users/{id}")
	public void changePassword(@RequestBody Map<String,Object> body, @PathVariable("id") int userid) {
		String password = body.get("loginPassword").toString();
		System.out.println("Password is : " + password + " Userid is : " + userid);
		userservice.updatePassword(password , userid);
		System.out.println("Password successfully updated");
	}
	
	@PutMapping(path="/logout")
	public void logout() {
		System.out.println("Logout of User Controller");
		userservice.logout();
	}
}
