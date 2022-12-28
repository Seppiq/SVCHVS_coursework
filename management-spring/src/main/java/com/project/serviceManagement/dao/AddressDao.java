package com.project.serviceManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.serviceManagement.model.Address;

@Repository
public interface AddressDao extends JpaRepository<Address,Integer>{

}
