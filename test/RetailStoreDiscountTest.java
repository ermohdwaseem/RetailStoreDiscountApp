package com.retail.app.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

import com.retail.app.RetailStoreDiscount;
import com.retail.app.cart.Cart;
import com.retail.app.cart.Item;
import com.retail.app.customer.Customer;
import com.retail.app.customer.CustomerType;
import com.retail.app.product.Product;

import junit.framework.Assert;

public class RetailStoreDiscountTest {

	RetailStoreDiscount storeDiscount = new RetailStoreDiscount();
	List<Item> withoutGroceriesitems = new ArrayList<>();
	List<Item> withGroceriesitems = new ArrayList<>();

	// -----------------------------------------------------------------------------------
	Calendar day2YrAfter = Calendar.getInstance(Locale.US);
	Calendar day2YrBefore = Calendar.getInstance(Locale.US);

	// -----------------------------------------------------------------------------------
	Customer storeCustomer;
	Customer affiliateCustomer;
	Customer otherCustomerAbove2Yr;
	Customer otherCustomerBelow2Yr;

	@Before
	public void before() {

		day2YrAfter.setTime(new GregorianCalendar(2016, 6, 10).getTime());
		day2YrBefore.setTime(new GregorianCalendar(2017, 10, 15).getTime());
		
		storeCustomer = new Customer(" Store Employee Customer", day2YrAfter.getTime(), day2YrAfter.getTime(),
				CustomerType.STORE_EMPLOYEE);
		affiliateCustomer = new Customer(" Store Employee Customer", day2YrBefore.getTime(),
				day2YrBefore.getTime(), CustomerType.AFFILIATE_EMPLOYEE);
		
		otherCustomerAbove2Yr = new Customer(" Other Above 2 Yr Customer", day2YrAfter.getTime(),
				day2YrAfter.getTime(), CustomerType.OTHER_EMPLOYEE);
		
		otherCustomerBelow2Yr = new Customer(" Other Below 2 Yr Customer", day2YrBefore.getTime(),
				day2YrBefore.getTime(), CustomerType.OTHER_EMPLOYEE);

		// -----------------------------------------------------------------------------------
		Product product1 = new Product("Samsung Mobile Cover", 100, false);
		Product product2 = new Product("Rice", 200, true);
		Product product3 = new Product("LG Mobile Charger", 300, false);
		Product product4 = new Product("Speeker", 100, false);
		Product product5 = new Product("white flour", 100, true);
		Product product6 = new Product("T Shirt", 100, false);

		// -----------------------------------------------------------------------------------
		Item item1 = new Item(product1, 2, 200, false);
		Item item2 = new Item(product2, 1, 200, true); // Groceries value is true
		Item item3 = new Item(product3, 1, 300, false);
		Item item4 = new Item(product4, 2, 200, false);
		Item item5 = new Item(product5, 1, 100, true); // Groceries value is true
		Item item6 = new Item(product6, 1, 190, false);

		withoutGroceriesitems.add(item1); // amt 200
		withoutGroceriesitems.add(item3); // amt 300
		withoutGroceriesitems.add(item4); // amt 200
		withoutGroceriesitems.add(item6); // amt 190

		withGroceriesitems.add(item1); // amt 200
		withGroceriesitems.add(item2); // amt 200
		withGroceriesitems.add(item3); // amt 300
		withGroceriesitems.add(item4); // amt 200
		withGroceriesitems.add(item5); // amt 100
		withGroceriesitems.add(item6); // amt 190
	}

	@Test
	public void withoutGroceriesCartTest() {

		// Scenario 1) Without Groceries + Store Employee Customer
		Cart withoutGroceriesCart = new Cart();

		withoutGroceriesCart.setCustomer(storeCustomer);
		withoutGroceriesCart.setItems(withoutGroceriesitems);
		withoutGroceriesCart.setTotalAmount(890);

		storeDiscount.applyDiscount(withoutGroceriesCart);
		
		System.out.println(withoutGroceriesCart.getTotalAmount());
		System.out.println(withoutGroceriesCart.getDiscTotalAmt());

		Assert.assertEquals(593.0f, withoutGroceriesCart.getDiscTotalAmt());

	}

	@Test
	public void withoutGroceriesAffiliateCustCartTest() {
		// Scenario 2) Without Groceries + Affiliate Employee Customer
		Cart withoutGroceriesAffiliateCustCart = new Cart();

		withoutGroceriesAffiliateCustCart.setCustomer(affiliateCustomer);
		withoutGroceriesAffiliateCustCart.setItems(withoutGroceriesitems);
		withoutGroceriesAffiliateCustCart.setTotalAmount(890);

		storeDiscount.applyDiscount(withoutGroceriesAffiliateCustCart);

		System.out.println(withoutGroceriesAffiliateCustCart.getTotalAmount());
		System.out.println(withoutGroceriesAffiliateCustCart.getDiscTotalAmt());

		Assert.assertEquals(761.0f, withoutGroceriesAffiliateCustCart.getDiscTotalAmt());
	}

	@Test
	public void withoutGroceriesOtherCustAbove2YrCartTest() {

		// Scenario 3) Without Groceries + Other Customer (Above 2Yr)
		Cart withoutGroceriesOtherCustAbove2YrCart = new Cart();
		
		withoutGroceriesOtherCustAbove2YrCart.setCustomer(otherCustomerAbove2Yr);
		withoutGroceriesOtherCustAbove2YrCart.setItems(withoutGroceriesitems);
		withoutGroceriesOtherCustAbove2YrCart.setTotalAmount(890);
		
		storeDiscount.applyDiscount(withoutGroceriesOtherCustAbove2YrCart);
		
		System.out.println(withoutGroceriesOtherCustAbove2YrCart.getTotalAmount());
		System.out.println(withoutGroceriesOtherCustAbove2YrCart.getDiscTotalAmt());
		Assert.assertEquals(805.5f, withoutGroceriesOtherCustAbove2YrCart.getDiscTotalAmt());
	}

	@Test
	public void withoutGroceriesOtherCustBelow2YrCartTest() {

		// Scenario 4) Without Groceries + Other Customer (Below 2Yr)
		Cart withoutGroceriesOtherCustBelow2YrCart = new Cart();

		withoutGroceriesOtherCustBelow2YrCart.setCustomer(otherCustomerBelow2Yr);
		withoutGroceriesOtherCustBelow2YrCart.setItems(withoutGroceriesitems);
		withoutGroceriesOtherCustBelow2YrCart.setTotalAmount(890);

		storeDiscount.applyDiscount(withoutGroceriesOtherCustBelow2YrCart);

		System.out.println(withoutGroceriesOtherCustBelow2YrCart.getTotalAmount());
		System.out.println(withoutGroceriesOtherCustBelow2YrCart.getDiscTotalAmt());

		Assert.assertEquals(850.0f, withoutGroceriesOtherCustBelow2YrCart.getDiscTotalAmt());

	}

	@Test
	public void withGroceriesCartTest() {

		// Scenario 5) With Groceries + Store Employee Customer
		Cart withGroceriesCart = new Cart();

		withGroceriesCart.setCustomer(storeCustomer);
		withGroceriesCart.setItems(withGroceriesitems);
		withGroceriesCart.setTotalAmount(1190);

		storeDiscount.applyDiscount(withGroceriesCart);

		System.out.println(withGroceriesCart.getTotalAmount());
		System.out.println(withGroceriesCart.getDiscTotalAmt());
		Assert.assertEquals(878.0f, withGroceriesCart.getDiscTotalAmt());

	}

}
