package com.project.serviceManagement.service;

import java.util.List;

import com.project.serviceManagement.model.Service;

public interface allService {
	
	public Service addBook(Service books);
	public void deleteBook(Integer id);
	public List<Service> viewBooks();
	public Service getBook(Integer id);
	public List<Service> getBookByCategory(String id);
	public Service updateBook(Service book, Integer id);

}
