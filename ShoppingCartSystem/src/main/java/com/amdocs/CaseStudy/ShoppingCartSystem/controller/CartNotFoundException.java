package com.amdocs.CaseStudy.ShoppingCartSystem.controller;

@SuppressWarnings("serial")
public class CartNotFoundException extends RuntimeException 
{
	public CartNotFoundException(String message)
	{
		super(message);
	}
}
