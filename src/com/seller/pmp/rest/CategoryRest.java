package com.seller.pmp.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seller.pmp.entities.Category;
import com.seller.pmp.services.CategoryService;

@Component
@Path("/categories")
public class CategoryRest {
	
	@Autowired
	private CategoryService categoryService;
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Category> getAllCategories(){
		return categoryService.getAllCategories();
	}

}
