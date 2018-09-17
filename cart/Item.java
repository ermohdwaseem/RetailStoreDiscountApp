package com.retail.app.cart;

import com.retail.app.product.Product;

public class Item {
	
	private Product product;
	private int count;
	private float totalAmount;
	private boolean isGroceries;
	
	public Item() {
	}
	
	public Item(Product product, int count, float totalAmount, boolean isGroceries) {
		super();
		this.product = product;
		this.count = count;
		this.totalAmount = totalAmount;
		this.isGroceries = isGroceries;
	}

	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	public boolean isGroceries() {
		return isGroceries;
	}
	public void setGroceries(boolean isGroceries) {
		this.isGroceries = isGroceries;
	}
	
	@Override
	public String toString() {
		return "Item [product=" + product + ", count=" + count + ", totalAmount=" + totalAmount + ", isGroceries="
				+ isGroceries + "]";
	}
	
}
