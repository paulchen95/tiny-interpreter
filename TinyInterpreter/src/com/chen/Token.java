package com.chen;

public class Token {
	private TokenEnum kind;
	private String value;

	public Token(TokenEnum kind, String value) {
		this.kind = kind;
		this.value = value;
	}

	public TokenEnum getKind() {
		return this.kind;
	}
	
	public Object getValue() {
		return this.value;
	}
	
	@Override
	public String toString() {
		switch(this.kind) {
			case Assignment:
				return "=";
			case LeftParan:
				return "(";
			case LetKeyword:
				return "LET";
			case Number:
				return value;
			case PlusOp:
				return "+";
			case RightParan:
				return ")";
			case Semicolon:
				return ";";
			case ShowKeyword:
				return "SHOW";
			case StarOp:
				return "*";
			case Variable:
				return "VAR(" + value + ")";
			default:
				break;
		}
		return "UNKNOWN";
	}
}
