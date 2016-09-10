package com.alexz.test.main1.add;

import java.util.List;

public class Parser {
	public static Expression parse(List<Token> tokens) {
		int count = 0;
		for (int i = 0; i < tokens.size(); i++) {
			Token token = tokens.get(i);
			if (token.getType() == Token.Type.OPEN_BRK) count++;
			if (token.getType() == Token.Type.CLOSE_BRK) count--;
			if (count == 0 &&
					(token.getType() == Token.Type.PLUS || token.getType() == Token.Type.MINUS))
				return new BinOp(
						parse(tokens.subList(0,i)),
						parse(tokens.subList(i+1,tokens.size())),
						token.getType()
				);
		}
		if (count != 0) throw new IllegalArgumentException();

		for (int i = 0; i < tokens.size(); i++) {
			Token token = tokens.get(i);
			if (token.getType() == Token.Type.OPEN_BRK) count++;
			if (token.getType() == Token.Type.CLOSE_BRK) count--;
			if (count == 0 &&
					(token.getType() == Token.Type.MUL || token.getType() == Token.Type.DIV))
				return new BinOp(
						parse(tokens.subList(0,i)),
						parse(tokens.subList(i+1,tokens.size())),
						token.getType()
				);
		}
		if (count != 0) throw new IllegalArgumentException();

		if (tokens.get(0).getType() == Token.Type.OPEN_BRK &&
				tokens.get(tokens.size() - 1).getType() == Token.Type.CLOSE_BRK)
			return parse(tokens.subList(1,tokens.size() - 1));

		if (tokens.size() == 1 && tokens.get(0).getType() == Token.Type.NUM)
			return new Num(Double.parseDouble(tokens.get(0).getValue()));

		throw new IllegalArgumentException();
	}


}
