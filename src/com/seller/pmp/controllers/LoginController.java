package com.seller.pmp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@RequestMapping("/")
	public String loginMethod() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String loginHandler(@RequestBody String body) {
		try {
		String username = body.split("&")[0].split("=")[1];
		String password = body.split("&")[1].split("=")[1];
		}
		catch(Exception e) {
			System.out.println("Problem Brother");
		}
		return "list-views";
	}
}
