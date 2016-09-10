package com.alexz.test.main1.add;

import java.math.BigDecimal;

public class BinOp extends Expression {
	public Expression left;
	public Expression right;
	public Token.Type value;

	public BinOp(Expression left, Expression right, Token.Type value) {
		this.left = left;
		this.right = right;
		this.value = value;
	}

	@Override
	public double calculate() {
		double result;
		switch (value) {
			case MINUS:
				result = left.calculate() - right.calculate();
				break;
			case PLUS:
				result = left.calculate() + right.calculate();
				break;
			case MUL:
				result = left.calculate() * right.calculate();
				break;
			case DIV:
				result = left.calculate() / right.calculate();
				break;
			default:
				throw new RuntimeException();
		}
		return new BigDecimal(result).setScale(4,BigDecimal.ROUND_DOWN).doubleValue();
	}
}
