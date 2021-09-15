package com.softra.bankingapplication.models;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softra.bankingapplication.exceptions.ServiceNotFoundException;

@Service
public class ServiceTrackerService {
	@Autowired
	private ServiceTrackerDao dao;
	
	public List<ServiceTracker> findAll() {
		return dao.findAll();
	}
	
	public ServiceTracker save(ServiceTracker serviceTracker) {
		return dao.save(serviceTracker);
	}
	
	public ServiceTracker findById(int id) {
		Optional<ServiceTracker> serviceTracker = dao.findById(id);
		return serviceTracker.get();
	}
	
	public void updateServiceRequest(String serviceStatus, int serviceId) throws ServiceNotFoundException{
		boolean exist = false;
		List<ServiceTracker> list = dao.findAll();
		for (ServiceTracker st : list) {
			if (st.getServiceId() == serviceId) {
				exist = true;
			}
			
		}
		if(exist == true) {
			dao.updateServiceRequest(serviceStatus, serviceId);
		} else {
			ServiceNotFoundException snfe = new ServiceNotFoundException("Id has not been found");
			throw snfe;
		}
		
	}
	
	public List<ServiceTracker> findByAccountId(int accountId) {
		return dao.findByAccountId(accountId);
	}
}
