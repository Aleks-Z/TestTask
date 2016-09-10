package com.alexz.test.main1.add;

import java.math.BigDecimal;

public class Num extends Expression {
	public double value;

	public Num(double value) {
		this.value = value;
	}

	@Override
	public double calculate() {
		return new BigDecimal(value).setScale(4,BigDecimal.ROUND_DOWN).doubleValue();
	}
}
