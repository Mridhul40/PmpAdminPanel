package com.seller.pmp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seller.pmp.dao.SellerDAO;
import com.seller.pmp.entities.JWT;
import com.seller.pmp.entities.Seller;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerDAO sellerDAO;

	@Override
	@Transactional
	public List<Seller> getAllSellers() {
		return sellerDAO.getAllSellers();
	}

	@Override
	@Transactional
	public Seller getSeller(int id) {
		return sellerDAO.getSeller(id);
	}

	@Override
	@Transactional
	public JWT addSeller(Seller seller) {
		return sellerDAO.addSeller(seller);
	}

	@Override
	@Transactional
	public Seller updateSeller(Seller seller) {
		return sellerDAO.updateSeller(seller);
	}

	@Override
	@Transactional
	public String deleteSeller(int id) {
		return sellerDAO.deleteSeller(id);
	}
	
	@Override
	@Transactional
	public JWT loginSeller(Seller seller) {
		return sellerDAO.loginSeller(seller);
	}
	
	@Override
	@Transactional
	public Seller getSellerFromToken(String token) {
		return sellerDAO.getSellerFromToken(token);
	}
	
}
