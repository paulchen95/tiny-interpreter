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
			int end = result.getEnd();
			
			if(list.get(end).getKind().equals(TokenEnum.Semicolon)) {
				return new Tuple(this, end + 1);
			}

			throw new RuntimeException("no semi");
			
			
		}
		else {
			throw new RuntimeException("he a no show");
		}
		
		
	}
}

