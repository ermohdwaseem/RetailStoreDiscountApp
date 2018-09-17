package com.retail.app.rule.impl;

import java.util.Date;

import com.retail.app.Utility;
import com.retail.app.cart.Cart;
import com.retail.app.constant.Constatnt;
import com.retail.app.customer.CustomerType;
import com.retail.app.rule.DiscountRule;

public class OtherEmployeeRule implements DiscountRule {

	@Override
	public int apply(Cart cart) {

		if (cart.getCustomer().getCustomerType().equals(CustomerType.OTHER_EMPLOYEE)) {

			int dayDiff = Utility.getYearDifference(cart.getCustomer().getCreatedDate(), new Date());

			if (dayDiff >= 2) {
				return Constatnt.OTHER_EMP_DISC_VALUE_PERC;
			}
		}
		return 0;
	}

}
