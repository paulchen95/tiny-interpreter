package com.chen.node;

import java.util.List;

import com.chen.Token;
import com.chen.TokenEnum;
import com.chen.Tuple;

public class ExprNode implements Node {

	@Override
	public Tuple makeNode(List<Token> list, int start) {
		Token currentToken = list.get(start);
		Token nextToken = list.get(start + 1);
		if (TokenEnum.LeftParan.equals(currentToken.getKind())) {
			//left paran
		} else if (TokenEnum.Variable.equals(currentToken.getKind())) {
			// var
		} else if (TokenEnum.Semicolon.equals(nextToken.getKind())) {
			
		} else {
			//it's complicated
		}
		// TODO Auto-generated method stub
		return null;
	}

}
