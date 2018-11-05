package com.seller.pmp.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seller.pmp.entities.Product;
import com.seller.pmp.entities.Seller;
import com.seller.pmp.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/list")
	public String listSellers(Model theModel) {
		List<Product> productList = productService.getAllProducts();
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonString = mapper.writeValueAsString(productList);
			theModel.addAttribute("products", jsonString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return "product-list";
	}
	
	@RequestMapping("/details/{id}")
	public String detailsProducts(Model theModel, @PathVariable("id") Integer id) {
		Product p = productService.getProduct(id);
		theModel.addAttribute("product", p);
		
		return "product-detail";
	}
	
	@RequestMapping("/status/{status}")
	public String updateSellers(@RequestParam("ids") String ids, @PathVariable("status") String status) {
		System.out.println(ids);
		for(String s : ids.split(",") ) {
			int id = Integer.parseInt(s);
			
			Product product = productService.getProduct(id);
			product.setStatus(status);
			productService.updateProduct(product);
		}
		
		return "redirect:/products/list";
		
	}
}
