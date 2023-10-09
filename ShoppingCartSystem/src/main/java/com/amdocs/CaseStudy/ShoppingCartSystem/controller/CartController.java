package com.amdocs.CaseStudy.ShoppingCartSystem.controller;

import com.amdocs.CaseStudy.ShoppingCartSystem.dao.*;
import com.amdocs.CaseStudy.ShoppingCartSystem.Entity.*;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api1")
public class CartController {

	CartDAO CartDAO;
	public CartController(CartDAO theCartDAO) {
		this.CartDAO = theCartDAO;
	}
	
	@GetMapping("/cart")
	public List<ShoppingCart> findAll()
	{
		List<ShoppingCart> cart = CartDAO.findAll();
		return cart;
		
	}
	
	@GetMapping("/cart/{CartID}")
	public ShoppingCart getCart(@PathVariable int CartID) throws CartNotFoundException
	{
		ShoppingCart cart = CartDAO.getCart(CartID);
		if(cart == null)
		{
			throw new CartNotFoundException("Cart ID not found.... " + CartID);
		}
		return cart;
	}
	
	@PostMapping("/cart")
	public ShoppingCart addCart(@RequestBody ShoppingCart thecart)
	{
		ShoppingCart Cart = CartDAO.addCart(thecart);
		return Cart;
	}
	
	@PutMapping("/cart")
	public ShoppingCart updateCart(@RequestBody ShoppingCart theCart)
	{
		ShoppingCart Cart = CartDAO.updateCart(theCart);
		return Cart;
	}
	
	@DeleteMapping("/cart/{CartID}")
	public void deleteCart(@PathVariable int CartID)
	{
		CartDAO.deleteCart(CartID);
		
	}

	}
