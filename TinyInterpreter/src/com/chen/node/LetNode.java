package com.chen.node;

import java.util.List;

import com.chen.Token;
import com.chen.TokenEnum;
import com.chen.Tuple;

public class LetNode extends StmtNode {
	private VarNode var;
	private ExprNode ex;

	@Override
	public Tuple makeNode(List<Token> list, int start) {
		int varIndex = start + 1;
		int exprIndex = start + 3;
		int next = start;
		while (!TokenEnum.Semicolon.equals(list.get(next).getKind())) {
			next++;
		}
		next++;
		
		Tuple varNodeResult = new VarNode().makeNode(list, varIndex);
		Tuple exprNodeResult = new ExprNode().makeNode(list, exprIndex);

		this.var = (VarNode) varNodeResult.getNode();
		this.ex = (ExprNode) exprNodeResult.getNode();

		Tuple result = new Tuple(this, next);
		return result;
	}
}
