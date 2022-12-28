package com.project.serviceManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.serviceManagement.model.Ratings;

public interface RatingsDao extends JpaRepository<Ratings, Integer> {

}
