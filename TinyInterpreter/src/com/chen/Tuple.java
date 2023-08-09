package com.chen;

import com.chen.node.Node;

public class Tuple {
	private Node node;
	private int next;
	
	public Tuple(Node node, int next) {
		this.node = node;
		this.next = next;
	}
	
	public Node getNode() {
		return this.node;
	}

	public int getNext() {
		return this.next;
	}
}
