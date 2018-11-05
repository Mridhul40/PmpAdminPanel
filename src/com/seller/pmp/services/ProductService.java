package com.seller.pmp.services;

import java.util.List;

import com.seller.pmp.entities.Product;

public interface ProductService {
	
	public List<Product> getAllProducts();
	public Product getProduct(int product_id);
	public Product addProduct(Product product);
	public Product updateProduct(Product product);
	public String deleteProduct(int product_id);
}
