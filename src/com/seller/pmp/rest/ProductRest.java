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

import com.seller.pmp.entities.Product;
import com.seller.pmp.services.ProductService;

@Component
@Path("/products")
public class ProductRest {
	
	@Autowired
	private ProductService productService;
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProducts(){
		List<Product> product_list = productService.getAllProducts();
		
		return product_list;
	}
	
	@GET
	@Path("/{p_code}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProduct(@PathParam("p_code") Integer p_code) {
		Product product = productService.getProduct(p_code);
		
		return product;
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Product addProduct(Product product) {
		Product saved_product = productService.addProduct(product);
		
		return saved_product;
	}
	
	@PUT
	@Path("/{p_code}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public Response updateProduct(@PathParam("p_code") Integer p_code, Product product) {
		Product prod = productService.getProduct(p_code);
		
		if(prod == null) {
			productService.addProduct(product);
		}
		else {
			productService.updateProduct(product);
		}
		
		return Response.status(Response.Status.OK).entity("The Product record has been updated").build();
	}
	
	@DELETE
	@Path("/{p_code}")
	public String deleteProduct(@PathParam("p_code") int p_code) {
		return productService.deleteProduct(p_code);
	
	}

}
