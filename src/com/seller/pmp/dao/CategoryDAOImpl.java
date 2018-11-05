package com.seller.pmp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.seller.pmp.entities.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO{
	
	@Autowired
	SessionFactory factory;
	
	@Override
	public List<Category> getAllCategories() {
		Session session = factory.getCurrentSession();
		List<Category> category_list = session.createQuery("from Category", Category.class).getResultList();
		
		return category_list;
	}
	
	public Category getCategory(int id) {
		Session session = factory.getCurrentSession();
		Category category = session.get(Category.class, id);
		
		return category;
	}

	@Override
	public Category addCategory(Category category) {
		
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(category);
		
		return category;
	}

	@Override
	public String deleteCategory(int id) {
		Session session = factory.getCurrentSession();
		Category category = getCategory(id);
		session.delete(category);
		
		return "Category deleted";
	}
	
	

}
