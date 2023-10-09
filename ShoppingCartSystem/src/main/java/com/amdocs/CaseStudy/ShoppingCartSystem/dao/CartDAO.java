package com.amdocs.CaseStudy.ShoppingCartSystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.amdocs.CaseStudy.ShoppingCartSystem.Entity.ShoppingCart;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class CartDAO {
	
	private EntityManager entityManager;
	
	public CartDAO(EntityManager theEntityManager) 
	{
		this.entityManager = theEntityManager; 
	}
	
	@SuppressWarnings("unchecked")
	@Transactional() // Works when the database changes are done through code
	public List<ShoppingCart> findAll() 
	{
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery = currentSession.createQuery("from ShoppingCart", ShoppingCart.class);
		
		List<ShoppingCart> cart = theQuery.getResultList();
		return cart;
		
	}
	
	@Transactional()
	public ShoppingCart getCart(int theID)
	{
		Session currentSession = entityManager.unwrap(Session.class);
		ShoppingCart cart = currentSession.get(ShoppingCart.class, theID);
		
		return cart;
	}
	
	@SuppressWarnings("deprecation")
	@Transactional()
	public ShoppingCart addCart(ShoppingCart theCart) 
	{
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theCart);
		return theCart;
	}

	@SuppressWarnings("deprecation")
	@Transactional()
	public ShoppingCart updateCart(ShoppingCart theCart) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theCart);
		return theCart;
	}

	@SuppressWarnings("deprecation")
	@Transactional()
	public ShoppingCart deleteCart(int CartID) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery = currentSession.createQuery("delete from ShoppingCart where id=:shcartID");
		theQuery.setParameter("shcartID", CartID);
		theQuery.executeUpdate();
		return null;
	}
	
	
	
}