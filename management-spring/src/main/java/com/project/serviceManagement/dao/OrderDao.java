package com.project.serviceManagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.serviceManagement.model.ServiceOrder;
import com.project.serviceManagement.model.Customer;

public interface OrderDao extends JpaRepository<ServiceOrder, Integer> {
	List<ServiceOrder> findByCustomer(Customer customer);
	
}
