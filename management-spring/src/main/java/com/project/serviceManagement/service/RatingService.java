package com.project.serviceManagement.service;

import java.util.List;

import com.project.serviceManagement.model.Ratings;

public interface RatingService {

	public Ratings addRatings(Ratings Customer) ;
	public Ratings updteRatings(Ratings Customer,Integer id);
	public void deleteCustomer(Integer id);
	public List<Ratings> viewRatings();
	public Ratings getRatings(Integer id);
}
