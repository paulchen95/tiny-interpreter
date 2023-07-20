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
	
    @Override
    public boolean equals(Object o) {
 
        // If the object is compared with itself then return true 
        if (o == this) {
            return true;
        }
 
        /* Check if o is an instance of Token or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Token)) {
            return false;
        }
         
        // typecast o to Token so that we can compare data members
        Token c = (Token) o;
         
        // Compare the data members and return accordingly
        switch(c.getKind()) {
			case Assignment:
			case LeftParan:
			case LetKeyword:
			case PlusOp:
			case RightParan:
			case Semicolon:
			case ShowKeyword:
			case StarOp:
				return c.getKind().equals(this.getKind());
			case Variable:
			case Number:
				return (c.getKind().equals(this.getKind())) &&
					   (c.getValue() != null) &&
					   (this.getValue() != null) &&
					   (c.getValue().equals(this.getValue()));
			default:
				break;
        }
        
        return true;
    }
}
