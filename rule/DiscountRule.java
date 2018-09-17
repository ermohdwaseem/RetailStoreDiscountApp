package com.retail.app.rule;

import com.retail.app.cart.Cart;

public interface DiscountRule {
	
	public int apply(Cart cart);
}
