package com.chen.node;

import java.util.List;

import com.chen.Token;
import com.chen.Tuple;

public class NumNode extends SimpExprNode {
	
	private int num;
	
	@Override
	public Tuple makeNode(List<Token> list, int start) {
		Token t = list.get(start);
		
		num = Integer.parseInt((String) t.getValue());
		Tuple result = new Tuple(this, start + 1);
		return result;
	}
}
