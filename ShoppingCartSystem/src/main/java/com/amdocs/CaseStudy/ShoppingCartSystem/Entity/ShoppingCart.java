package com.amdocs.CaseStudy.ShoppingCartSystem.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

// Mapping Employee class to Cart Table
@Entity
@Table(name="Cart") // Adding the values to database 
@SequenceGenerator(name="MySequence", sequenceName="cart_sequence", initialValue=50, allocationSize=1)
public class ShoppingCart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MySequence") // Generated the type as Sequence in the database
	
	@Column(name="ID") // Creating columns in the table
	private int id;
	
	@Column(name="LIST_ITEM")
	private String ListItem;
	
	@Column(name="PRODUCT_NAME")
	private String ProductName;
	
	@Column(name="PRICE")
	private double price;
	
	public ShoppingCart()
	{
		
	}

	public ShoppingCart(int id, String listItem, String productName, double price) {
		super();
		this.id = id;
		this.ListItem = listItem;
		this.ProductName = productName;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListItem() {
		return ListItem;
	}

	public void setListItem(String listItem) {
		this.ListItem = listItem;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		this.ProductName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	
}