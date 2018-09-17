package com.retail.app.calculator.impl;

import com.retail.app.calculator.Calculator;

public class CalculatorAmount implements Calculator {

	@Override
	public float calculate(float totalPrice, int discount) {
		
		float dicountAmount =  ((int)totalPrice / 100) * discount;
		return dicountAmount;
	}

}
