package com.seller.pmp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seller.pmp.dao.ProductDAO;
import com.seller.pmp.entities.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDAO productDAO;
	
	@Override
	@Transactional
	public List<Product> getAllProducts() {
		return productDAO.getAllProducts();
	}

	@Override
	@Transactional
	public Product getProduct(int product_id) {
		return productDAO.getProduct(product_id);
	}

	@Override
	@Transactional
	public Product addProduct(Product product) {
		return productDAO.addProduct(product);
	}

	@Override
	@Transactional
	public Product updateProduct(Product product) {
		return productDAO.updateProduct(product);
	}

	@Override
	@Transactional
	public String deleteProduct(int product_id) {
		return productDAO.deleteProduct(product_id);
	}

}
