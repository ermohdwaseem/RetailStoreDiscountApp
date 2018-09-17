package com.retail.app.cart;

import java.util.List;

import com.retail.app.customer.Customer;

public class Cart {

	private List<Item> Items;
	private Customer customer;
	private float totalAmount;
	private float discTotalAmt;

	public List<Item> getItems() {
		return Items;
	}

	public void setItems(List<Item> items) {
		Items = items;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public float getDiscTotalAmt() {
		return discTotalAmt;
	}

	public void setDiscTotalAmt(float discTotalAmt) {
		this.discTotalAmt = discTotalAmt;
	}

	@Override
	public String toString() {
		return "Cart [Items=" + Items + ", customer=" + customer + ", totalAmount=" + totalAmount + "]";
	}

}
