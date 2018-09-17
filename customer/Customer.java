package com.retail.app.customer;

import java.util.Date;

public class Customer {

	private String name;
	private Date createdDate;
	private Date modifyDate;
	private CustomerType customerType;
	
	public Customer() {
	}

	public Customer(String name, Date createdDate, Date modifyDate, CustomerType customerType) {
		super();
		this.name = name;
		this.createdDate = createdDate;
		this.modifyDate = modifyDate;
		this.customerType = customerType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", createdDate=" + createdDate + ", modifyDate=" + modifyDate
				+ ", customerType=" + customerType + "]";
	}

}

