package com.seller.pmp.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.seller.pmp.entities.JWT;
import com.seller.pmp.entities.Seller;

@Repository
public class SellerDAOImpl implements SellerDAO {

	@Autowired
	SessionFactory factory;
	
	@Override
	public List<Seller> getAllSellers() {
		
		Session session = factory.getCurrentSession();
		List<Seller> seller_list = session.createQuery("from Seller", Seller.class).getResultList();
		
		return seller_list;
	}

	@Override
	public Seller getSeller(int id) {

		Session session = factory.getCurrentSession();
		Seller seller = session.get(Seller.class, id);

		return seller;
		
	}

	@Override
	public JWT addSeller(Seller seller) {
		
		Session session = factory.getCurrentSession();
		
		UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        
        JWT jwt = new JWT(randomUUIDString);
        
        session.saveOrUpdate(jwt);
		
        seller.setJwt(jwt);
		
		session.saveOrUpdate(seller);
		
		return jwt;
	}
	
	@Override
	public JWT loginSeller(Seller seller) {
		Session session = factory.getCurrentSession();
		Seller nseller = session.createQuery("from Seller where email=:email", Seller.class).setParameter("email", seller.getEmail()).getSingleResult();

		return nseller.getJwt();
	}

	@Override
	public Seller updateSeller(Seller seller) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(seller);
		
		return seller;
	}

	@Override
	public String deleteSeller(int id) {
		Seller seller = getSeller(id);
		Session session = factory.getCurrentSession();
		session.delete(seller);
		
		return "Seller with id "+id+" deleted";
	}
	
	@Override
	public Seller getSellerFromToken(String token) {
		Session session = factory.getCurrentSession();
		JWT jwt = session.createQuery("from JWT where token=:token", JWT.class).setParameter("token", token).getSingleResult();
		Seller seller = session.createQuery("from Seller where jwt_id=:jwt_id", Seller.class).setParameter("jwt_id", jwt.getId()).getSingleResult();
		
		return seller;
	}
	
	

}
