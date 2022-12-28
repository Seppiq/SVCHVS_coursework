package com.project.serviceManagement.service;

import java.util.List;

import com.project.serviceManagement.model.Category;

public interface CategoryService {
	public Category addCategory(Category category) ;
	public Category updteCategory(Category category,Integer id);
	public void deleteCategory(Integer id);
	public List<Category> viewCategories();
	public Category getCategory(Integer id);

}
