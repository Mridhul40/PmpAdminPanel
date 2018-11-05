package com.seller.pmp.dao;

import java.util.List;

import com.seller.pmp.entities.Category;

public interface CategoryDAO {
	
	public List<Category> getAllCategories();
	public Category addCategory(Category category);
	public String deleteCategory(int id);
}
