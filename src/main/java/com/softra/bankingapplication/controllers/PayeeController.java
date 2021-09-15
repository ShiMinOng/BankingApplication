package com.softra.bankingapplication.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.softra.bankingapplication.exceptions.AccountNotFoundException;
import com.softra.bankingapplication.exceptions.OwnAccountException;
import com.softra.bankingapplication.exceptions.PayeeNotFoundException;
import com.softra.bankingapplication.models.Payee;
import com.softra.bankingapplication.models.PayeeService;

@RestController
@CrossOrigin("*")
public class PayeeController {
	@Autowired
	private PayeeService service;
	
	@GetMapping("/payees")
	public List<Payee> getAllPayees() {
		return service.findAll();
	}
	
	@PostMapping("/payees")
	public Payee createPayee(@RequestBody Map<String, Object> beforeMap) throws OwnAccountException, AccountNotFoundException  {
		System.out.println(beforeMap);
		int payeracctid = Integer.parseInt(beforeMap.get("accountId").toString());
		int payeeacctid = Integer.parseInt(beforeMap.get("payeeAccountID").toString());
		String nickname = beforeMap.get("nickname").toString();
		Payee payee = new Payee(payeracctid, payeeacctid, nickname);
		System.out.println(payee);
		return service.save(payee);
	}
	
	@GetMapping(path="/payees/{payer_id}")
	public List<Payee> getPayeeById(@PathVariable("payer_id") int id) throws PayeeNotFoundException {
		List<Payee> payees = service.findPayees(id);
//		Payee p = service.findById(id);
//		if(p == null) {
//			System.out.println("Payee not found");
//			PayeeNotFoundException pnfe = new PayeeNotFoundException("Payee not found");
//			throw pnfe;
//		}
		return payees;
		
	}
}
