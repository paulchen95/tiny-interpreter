package com.chen;

import java.util.ArrayList;
import java.util.List;

public class Parser {
	public List<Token> parse(String input) {
		
		String string = input;
		ArrayList<Token> tokens = new ArrayList<Token>();
		int next;
		
		for(int i = 0; i < string.length(); i++) {
			String current = string.substring(i, i+1);
			if(current.equals(" ")) {
				continue;
			}
			else if(current.equals(";")) {
				tokens.add(new Token(TokenEnum.Semicolon, null));
			}
			else if(current.equals("(")) {
				tokens.add(new Token(TokenEnum.LeftParan, null));
			}
			else if(current.equals(")")) {
				tokens.add(new Token(TokenEnum.RightParan, null));
			}
			else if(current.equals("+")) {
				tokens.add(new Token(TokenEnum.PlusOp, null));
			}
			else if(current.equals("*")) {
				tokens.add(new Token(TokenEnum.StarOp, null));
			}
			else if(current.equals("=")) {
				tokens.add(new Token(TokenEnum.Assignment, null));
			}
			else if(isNumeric(current)) {
				next = 1;
				
				while(isNumeric(string.substring(i, i + next + 1))){
					next++;
					
				}
				tokens.add(new Token(TokenEnum.Number, string.substring(i,i+next)));
				i += next - 1;
				continue;
			}
			if(current.equals("L")) {
				if(string.substring(i, i + 3).equals("Let")) {
					tokens.add(new Token(TokenEnum.LetKeyword, null));
					i += 2;
					continue;
				}
			}
			if(current.equals("S")) {
				if(string.substring(i, i + 4).equals("Show")) {
					tokens.add(new Token(TokenEnum.ShowKeyword, null));
					i += 3;
					continue;
				}
			}
			else if(isAlpha(current)) {
				next = 1;
				
				while(isAlpha(string.substring(i, i + next + 1))){
					next++;
				}
				
				tokens.add(new Token(TokenEnum.Variable, string.substring(i, i + next)));
				i += next - 1;
				continue;
			}
			else {
				continue;
			}
			
		}
		
		
		return tokens;
	}
	
	private boolean isNumeric(String s) {
		try {
			Double.parseDouble(s);
		}catch(NumberFormatException e) {
			return false;
		}
		
		return true;
	}
	
	private boolean isAlpha(String s) {
		char[] chars = s.toCharArray();

	    for (char c : chars) {
	        if(!Character.isLetter(c)) {
	            return false;
	        }
	    }

	    return true;
	}
}
