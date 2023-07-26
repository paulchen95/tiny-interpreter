package com.chen.node;

import java.util.List;

import com.chen.Token;
import com.chen.Tuple;

public class LetNode extends StmtNode {
	private VarNode var;
	private ExprNode ex;

	@Override
	public Tuple makeNode(List<Token> list, int start) {
		return null;
	}
}
