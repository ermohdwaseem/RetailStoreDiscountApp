package com.retail.app.rule.impl;

import com.retail.app.cart.Cart;
import com.retail.app.constant.Constatnt;
import com.retail.app.customer.CustomerType;
import com.retail.app.rule.DiscountRule;

public class StoreEmployeeRule implements DiscountRule {

	@Override
	public int apply(Cart cart) {

		if (cart.getCustomer().getCustomerType().equals(CustomerType.STORE_EMPLOYEE)) {
			return Constatnt.STORE_EMP_DISC_VALUE_PERC;
		}

		return 0;
	}

}
