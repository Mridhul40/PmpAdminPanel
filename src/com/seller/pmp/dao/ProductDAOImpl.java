package com.seller.pmp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.seller.pmp.entities.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SessionFactory factory;
	
	@Override
	public List<Product> getAllProducts() {
		Session session = factory.getCurrentSession();
		List<Product> product_list = session.createQuery("from Product", Product.class).getResultList();
		
		return product_list;
	}

	@Override
	public Product getProduct(int product_id) {
		Session session = factory.getCurrentSession();
		Product product = session.get(Product.class, product_id);

		return product;
	}

	@Override
	public Product addProduct(Product product) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(product);

		return product;
	}

	@Override
	public Product updateProduct(Product product) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(product);
		
		return product;
	}

	@Override
	public String deleteProduct(int product_id) {
		Product product = getProduct(product_id);
		Session session = factory.getCurrentSession();
		session.delete(product);
		
		return "Seller with id "+product_id+" deleted";
	}
	
	
}
