package com.chen.node;

import java.util.List;

import com.chen.Token;
import com.chen.Tuple;

public interface Node {
	Tuple makeNode(List<Token> list, int start);
}
