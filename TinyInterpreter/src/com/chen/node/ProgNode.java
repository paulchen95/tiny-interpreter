package com.chen.node;

import java.util.ArrayList;
import java.util.List;

import com.chen.Token;
import com.chen.Tuple;

public class ProgNode implements Node {

	private List<StmtNode> stmts;

	public List<StmtNode> getStmts() {
		return this.stmts;
	}

	@Override
	public Tuple makeNode(List<Token> tokens, int start) {
		stmts = new ArrayList<StmtNode>();
		while (start < tokens.size()) {
			StmtNode stmt = new StmtNode();
			Tuple output = stmt.makeNode(tokens, start);
			stmts.add((StmtNode) output.getNode());
			start = output.getNext();
		}
		Tuple tuple = new Tuple(this, start);
		return tuple;
	}
}
