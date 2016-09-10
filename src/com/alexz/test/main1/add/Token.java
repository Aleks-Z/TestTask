package com.alexz.test.main1.add;

public class Token {
	public enum Type {
		PLUS("^\\+$"),
		MINUS("^-$"),
		MUL("^\\*$"),
		DIV("^\\/$"),
		OPEN_BRK("^\\($"),
		CLOSE_BRK("^\\)$"),
		NUM("^[0-9]+(\\.[0-9]+)?$");

		public final String regex;

		Type(String regex) {
			this.regex = regex;
		}
	}

	private String mValue;
	private Type mType;

	public Token(String value, Type type) {
		this.mValue = value;
		this.mType = type;
	}

	public String getValue() {
		return mValue;
	}

	public Type getType() {
		return mType;
	}

}
