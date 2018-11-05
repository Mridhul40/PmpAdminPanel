package com.seller.pmp.services;

import java.util.List;

import com.seller.pmp.entities.JWT;
import com.seller.pmp.entities.Seller;

public interface SellerService {

	public List<Seller> getAllSellers();
	public Seller getSeller(int id);
	public JWT addSeller(Seller seller);
	public Seller updateSeller(Seller seller);
	public String deleteSeller(int id);
	public JWT loginSeller(Seller seller);
	public Seller getSellerFromToken(String token);
}
