package com.chen.node;

import java.util.List;

import com.chen.Token;
import com.chen.Tuple;

public class ComExprNode extends ExprNode {

	private ExprNode left;
	private OpNode op;
	private ExprNode right;
	
	@Override
	public Tuple makeNode(List<Token> list, int start) {
		return null;
	}
}
