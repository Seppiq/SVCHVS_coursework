package com.project.serviceManagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.serviceManagement.model.Service;
import com.project.serviceManagement.model.Category;

@Repository
public interface ServiceDao extends JpaRepository<Service, Integer>{

	List<Service> findAllByCategory(Category category);
}
