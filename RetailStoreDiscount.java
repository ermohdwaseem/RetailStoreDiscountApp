package com.retail.app;

import java.util.ArrayList;
import java.util.List;

import com.retail.app.calculator.Calculator;
import com.retail.app.calculator.impl.CalculatorAmount;
import com.retail.app.calculator.impl.CalculatorPercentage;
import com.retail.app.cart.Cart;
import com.retail.app.cart.Item;
import com.retail.app.rule.DiscountRule;
import com.retail.app.rule.impl.AffiliateEmployeeRule;
import com.retail.app.rule.impl.OtherEmployeeRule;
import com.retail.app.rule.impl.StoreEmployeeRule;
import com.retail.app.rule.impl.TotalBillRule;

public class RetailStoreDiscount {

	public Cart applyDiscount(Cart cart) {
		
		float groceriesAmount = 0;
		boolean isDiscount = false;
		List<DiscountRule> discountRules = new ArrayList<>();
		discountRules.add(new StoreEmployeeRule());
		discountRules.add(new AffiliateEmployeeRule());
		discountRules.add(new OtherEmployeeRule());

		for (DiscountRule rule : discountRules) {

			int discPerc = rule.apply(cart);

			if (discPerc > 0) {
				isDiscount = true;
				Calculator calculator = new CalculatorPercentage();
				groceriesAmount = getGroceriesAmount(cart);
				float discAmt = calculator.calculate(cart.getTotalAmount() - groceriesAmount, discPerc);
				cart.setDiscTotalAmt(cart.getTotalAmount() - discAmt);
				break;

			}

		}
		
		if(!isDiscount) {
			cart.setDiscTotalAmt(cart.getTotalAmount());
		}

		DiscountRule dr = new TotalBillRule();
		int disc = dr.apply(cart);
		if (disc > 0) {
			Calculator calc = new CalculatorAmount();
			cart.setDiscTotalAmt(cart.getDiscTotalAmt() - calc.calculate(cart.getDiscTotalAmt(), disc));
		}

		return cart;
	}
	
	protected float getGroceriesAmount(Cart cart) {
		float amount = 0;
		for(Item item : cart.getItems()) {
			if(item.getProduct().isGroceries()) {
				amount +=  item.getTotalAmount();
			}
		}
		return amount;
	}

}
