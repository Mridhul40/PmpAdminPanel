package com.seller.pmp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seller.pmp.dao.CategoryDAO;
import com.seller.pmp.entities.Category;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Override
	@Transactional
	public List<Category> getAllCategories(){
		return categoryDAO.getAllCategories();
	}
	
	@Override
	@Transactional
	public Category addCategory(Category category) {
		return categoryDAO.addCategory(category);
	}
	
	@Override
	@Transactional
	public String deleteCategory(int id) {
		return categoryDAO.deleteCategory(id);
	}
}
