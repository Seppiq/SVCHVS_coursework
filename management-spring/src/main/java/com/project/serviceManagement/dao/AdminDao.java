package com.project.serviceManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.serviceManagement.model.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin,Integer>{

}
