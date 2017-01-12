package com.design;

import com.design.NodeList.Node;

 


public class LinkedListNode {
	
	public static void main(String[] args) {
		NodeList list = new NodeList();
		list.addNode("H");
		list.addNode("K");
		list.addNode("H");
		list.addNode("R");
		Node node  = list.getNodes();
		System.out.println(list.getSize());
		while(node.getNext() != null) {
			System.out.println(node.getData());
			node = node.getNext();
		}
		System.out.println(node.getData());
	}

}

class NodeList {
	Node head;
	int listCount = 0;
	
	void addNode(String data) {
		Node tempNode = new Node(data);
		if(head == null) {
			head = tempNode;
		} else {
			Node tmpHead = head;
	        while (tmpHead.getNext() != null) {
	        	tmpHead = tmpHead.getNext();
	        }
	        tmpHead.setNext(tempNode);
		}
        listCount++;
	}
	
	public Node getNodes() {
		return head;
	}


	public int getSize() {
		return listCount;
	}


	
	
	class Node {
		String data;
		Node next;
		
		Node(String data) {
			this.data = data;
			next = null;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}
}
