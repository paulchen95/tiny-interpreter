package com.chen;

import com.chen.node.Node;

public class Tuple {
	private Node node;
	private int end;
	
	public Tuple(Node node, int end) {
		this.node = node;
		this.end = end;
	}
	
	public Node getNode() {
		return this.node;
	}

	public int getEnd() {
		return this.end;
	}
}
