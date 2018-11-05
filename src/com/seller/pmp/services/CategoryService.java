package com.seller.pmp.services;

import java.util.List;

import com.seller.pmp.entities.Category;

public interface CategoryService {
	
	public List<Category> getAllCategories();
	public Category addCategory(Category category);
	public String deleteCategory(int id);
}
