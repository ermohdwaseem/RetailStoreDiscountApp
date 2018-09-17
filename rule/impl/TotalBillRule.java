package com.retail.app.rule.impl;

import com.retail.app.cart.Cart;
import com.retail.app.constant.Constatnt;
import com.retail.app.rule.DiscountRule;

public class TotalBillRule implements DiscountRule {

	@Override
	public int apply(Cart cart) {
		if(cart.getDiscTotalAmt()>=Constatnt.DISCOUNT_DOLLAR_ON_BILL) {
			return Constatnt.DISCOUNT_DOLLAR_ON_BILL_AMT;
		}
		return 0;
	}

}
