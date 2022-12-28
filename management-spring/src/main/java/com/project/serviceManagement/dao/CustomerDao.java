package com.project.serviceManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.serviceManagement.model.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {

	Customer findByPhoneNumber(String phoneNumber);
}
