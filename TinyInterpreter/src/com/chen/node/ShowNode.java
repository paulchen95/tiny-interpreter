package com.chen.node;

import java.util.List;

import com.chen.Token;
import com.chen.TokenEnum;
import com.chen.Tuple;

public class ShowNode extends StmtNode {

	private VarNode var;
	
	@Override
	public Tuple makeNode(List<Token> list, int start) {
		
		if(list.get(start).getKind().equals(TokenEnum.ShowKeyword)) {
			VarNode var = new VarNode();
			Tuple result = var.makeNode(list, start + 1);
			int next = result.getNext();
			
			if(list.get(next).getKind().equals(TokenEnum.Semicolon)) {
				return new Tuple(this, next + 1);
			}

			throw new RuntimeException("no semi");
			
			
		}
		else {
			throw new RuntimeException("he a no show");
		}
		
		
	}
}

