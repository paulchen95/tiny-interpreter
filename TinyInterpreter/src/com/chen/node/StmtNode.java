package com.chen.node;

import java.util.List;

import com.chen.Token;
import com.chen.TokenEnum;
import com.chen.Tuple;

public class StmtNode implements Node {

	@Override
	public Tuple makeNode(List<Token> list, int start) {
		Token t = list.get(start);
		
		//if it is a Let Stmt
		if (TokenEnum.LetKeyword.equals(t.getKind())) {
			LetNode letNode = new LetNode();
			return letNode.makeNode(list, start);
		} else if (TokenEnum.ShowKeyword.equals(t.getKind())) {
			ShowNode showNode = new ShowNode();
			return showNode.makeNode(list, start);
		}
		//print debug stmt because it is really wrong
		throw new RuntimeException("Something really wrong, you suck!");
	}

}
