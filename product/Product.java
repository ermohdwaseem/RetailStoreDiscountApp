package com.retail.app.product;

public class Product {
	
	private String name;
	private float price;
	private boolean isGroceries;
	
	public Product() {
	}
	
	
	public Product(String name, float price, boolean isGroceries) {
		super();
		this.name = name;
		this.price = price;
		this.isGroceries = isGroceries;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public boolean isGroceries() {
		return isGroceries;
	}


	public void setGroceries(boolean isGroceries) {
		this.isGroceries = isGroceries;
	}


	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", isGroceries=" + isGroceries + "]";
	}

}
