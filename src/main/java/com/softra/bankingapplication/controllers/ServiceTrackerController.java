package com.softra.bankingapplication.controllers;

import java.util.Date;
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

import com.softra.bankingapplication.exceptions.ServiceNotFoundException;
import com.softra.bankingapplication.models.ServiceTracker;
import com.softra.bankingapplication.models.ServiceTrackerService;

@RestController
@CrossOrigin("*")
public class ServiceTrackerController {
	@Autowired
	private ServiceTrackerService service;
	
	@GetMapping("/services")
	public List<ServiceTracker> getAllServices() {
		return service.findAll();
	}
	
	@PostMapping("/services")
	public ServiceTracker createService(@RequestBody Map<String, Object> beforeMap) {
		String serviceDesc = beforeMap.get("serviceDesc").toString();
		Date serviceRaiseDate = new Date();
		String serviceStatus = beforeMap.get("serviceStatus").toString();
//		int accountId = (int) beforeMap.get("accountId");
		int accountId = Integer.parseInt(beforeMap.get("accountId").toString());
		ServiceTracker st = new ServiceTracker(serviceDesc,serviceRaiseDate,serviceStatus,accountId);
		return service.save(st);
	}
	
	@GetMapping(path="/services/{id}")
	public ServiceTracker findServiceById(@PathVariable("id") int id) {
		ServiceTracker st = service.findById(id);
		if(st==null) {
			System.out.println("service number " + id + " not found");
			ServiceNotFoundException snfe = new ServiceNotFoundException("Service with id: "+id+" not found");
			throw snfe;
		}
		return st;
	}
	
	@PutMapping("/services/status")
	public void updateServiceStatus(@RequestBody Map<String,Object> body) {
		String status = body.get("serviceStatus").toString();
		int serviceId = Integer.parseInt(body.get("serviceId").toString());
		System.out.println("updating status");
		service.updateServiceRequest(status, serviceId);
		System.out.println("status updated");
	}
	
	@GetMapping(path="/services/account/{account_id}")
	public List<ServiceTracker> getAllServicesForAccount(@PathVariable("account_id") int accountId) {
		List<ServiceTracker> serviceTickets = service.findByAccountId(accountId);
		if(serviceTickets.size() == 0) {
			ServiceNotFoundException snfe = new ServiceNotFoundException("No raised services found for account: "+accountId);
			throw snfe;
		}
		return serviceTickets;
	}
	
}
