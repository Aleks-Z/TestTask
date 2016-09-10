package com.alexz.test.main1;

import com.alexz.test.main1.add.Expression;
import com.alexz.test.main1.add.Lexer;
import com.alexz.test.main1.add.Parser;
import com.alexz.test.main1.add.Token;

import java.util.List;
import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		System.out.println("Input expression : ");
		Scanner scanner = new Scanner(System.in);
		String expression = scanner.next();

		List<Token> tokens = Lexer.parse(expression);
		try {
			Expression expr = Parser.parse(tokens);
			System.out.println("Result : ");
			System.out.println(expr.calculate());
		}  catch (IllegalArgumentException e) {
			System.out.println("null");
		}
	}
}
