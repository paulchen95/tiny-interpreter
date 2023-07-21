package com.chen.node;

public class ComExprNode extends ExprNode {

	private ExprNode left;
	private OpNode op;
	private ExprNode right;
	
	public ComExprNode(ExprNode left, OpNode op, ExprNode right) {
		this.left = left;
		this.op = op;
		this.right = right;

	}
}
