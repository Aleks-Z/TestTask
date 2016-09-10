package com.alexz.test.main1.add;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
	public static List<Token> parse(String expression) {
		String s;
		for (int i = expression.length(); i >= 1; i--) {
			s = expression.substring(0, i);
			for (Token.Type t : Token.Type.values()) {
				if (s.matches(t.regex)) {
					Token token = new Token(s,t);
					List<Token> list = parse(expression.substring(i));
					list.add(0,token);
					return list;
				}
			}
		}
		return new ArrayList<>();

	}
}
