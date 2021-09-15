package com.softra.bankingapplication.models;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceTrackerDao extends JpaRepository<ServiceTracker, Integer> {

	@Modifying
	@Transactional
	@Query("UPDATE serviceTracker st SET st.serviceStatus = :service_status WHERE st.serviceId = :service_id")
	void updateServiceRequest(@Param("service_status") String serviceStatus, @Param("service_id") int serviceId);
	
	List<ServiceTracker> findByAccountId(@Param("account_id") int accountId);
}
