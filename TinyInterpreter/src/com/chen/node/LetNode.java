package com.chen.node;

public class LetNode extends StmtNode {

	private VarNode var;
	private ExprNode ex;
	
	public LetNode(VarNode var, ExprNode ex) {
		this.var = var;
		this.ex = ex;
	}
}
