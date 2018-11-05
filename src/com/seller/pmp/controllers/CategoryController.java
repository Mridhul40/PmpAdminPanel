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
import com.seller.pmp.entities.Category;
import com.seller.pmp.services.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/list")
	public String listCategories(Model theModel) {
		List<Category> categoryList = categoryService.getAllCategories();
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonString = mapper.writeValueAsString(categoryList);
			theModel.addAttribute("categories", jsonString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "category-list";
	}
	
	@RequestMapping("/add/{category}")
	public String addCategory(Model theModel, @PathVariable("category") String category) {
		Category newCategory = new Category(category);
		categoryService.addCategory(newCategory);
		
		return "redirect:/categories/list";
		
	}
	
	@RequestMapping("/delete")
	public String deleteCategory(Model theModel, @RequestParam("ids") String ids) {
		
		for(String s : ids.split(",") ) {
			int id = Integer.parseInt(s);
			String msg = categoryService.deleteCategory(id);
		}
		
		return "redirect:/categories/list";
	}
	
}
