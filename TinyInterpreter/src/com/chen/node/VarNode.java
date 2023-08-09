package com.chen.node;

import java.util.List;

import com.chen.Token;
import com.chen.Tuple;

public class VarNode extends SimpExprNode {

	private String var;
	
	@Override
	public Tuple makeNode(List<Token> list, int start) {
		
		Token t = list.get(start);
		
		var = (String) t.getValue();
		Tuple var = new Tuple(this, start + 1);
		
		return var;
	}
}
