package com.chen.node;

import java.util.List;

import com.chen.Token;
import com.chen.Tuple;

public class OpNode implements Node {

	private OpEnum op;
	
	public OpNode(OpEnum op) {
		this.op = op;
	}

	@Override
	public Tuple makeNode(List<Token> list, int start) {
		// TODO Auto-generated method stub
		return null;
	}
}
