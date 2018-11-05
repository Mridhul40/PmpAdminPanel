package com.seller.pmp.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seller.pmp.entities.JWT;
import com.seller.pmp.entities.Seller;
import com.seller.pmp.services.SellerService;

@Component
@Path("/sellers")
public class SellerRest {
	
	@Autowired
	private SellerService sellerService;
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Seller> getSellers(){
		List<Seller> seller_list = sellerService.getAllSellers();
		
		return seller_list;
	}
	
	@GET
	@Path("/{s_code}")
	@Produces(MediaType.APPLICATION_JSON)
	public Seller getSeller(@PathParam("s_code") Integer s_code) {
		Seller seller = sellerService.getSeller(s_code);
		
		return seller;
	}
	
	@GET
	@Path("/token/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public Seller getSellerFromToken(@PathParam("token") String token) {
		Seller seller = sellerService.getSellerFromToken(token);
		
		return seller;
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public JWT addSeller(Seller seller) {

		JWT jwtToken = sellerService.addSeller(seller);
		
		return jwtToken;
	}
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public JWT loginSeller(Seller seller) {
		JWT jwtToken = sellerService.loginSeller(seller);
		
		return jwtToken;
	}
	
	@PUT
	@Path("/{s_code}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public Response updateSeller(@PathParam("s_code") Integer s_code, Seller seller) {
		Seller sell = sellerService.getSeller(s_code);
		
		if(sell == null) {
			sellerService.addSeller(seller);
		}
		else {
			sellerService.updateSeller(seller);
		}
		
		return Response.status(Response.Status.OK).entity("The Seller record has been updated").build();
	}
	
	@DELETE
	@Path("/{s_code}")
	public String deleteSeller(@PathParam("s_code") int s_code) {
		return sellerService.deleteSeller(s_code);
	
	}
}
