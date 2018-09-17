package com.retail.app.calculator.impl;

import com.retail.app.calculator.Calculator;

public class CalculatorPercentage implements Calculator {

	@Override
	public float calculate(float totalPrice, int discount) {
		float dicountAmount = (totalPrice / 100) * discount;
		return dicountAmount;
	}

}
