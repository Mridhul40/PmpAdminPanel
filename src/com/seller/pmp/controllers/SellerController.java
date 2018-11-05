package com.seller.pmp.controllers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seller.pmp.entities.Seller;
import com.seller.pmp.services.SellerService;

@Controller
@RequestMapping("/sellers")
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	@RequestMapping("/list")
	public String listSellers(Model theModel) {
		List<Seller> sellerList = sellerService.getAllSellers();
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonString = mapper.writeValueAsString(sellerList);
			theModel.addAttribute("sellers", jsonString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return "seller-list";
	}
	
	@RequestMapping("/details/{id}")
	public String detailsSeller(Model theModel, @PathVariable("id") Integer id) {
		Seller s = sellerService.getSeller(id);
		theModel.addAttribute("seller", s);
		
		return "seller-detail";
	}
	
	@RequestMapping("/status/{status}")
	public String updateSellers(@RequestParam("ids") String ids, @PathVariable("status") String status) {
		
		for(String s : ids.split(",") ) {
			int id = Integer.parseInt(s);
			
			Seller seller = sellerService.getSeller(id);
			seller.setStatus(status);
			sellerService.updateSeller(seller);
		}
		
		return "redirect:/sellers/list";
		
	}
}
