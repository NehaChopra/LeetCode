//https://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
package LinkedList;

import java.util.Stack;

class Node {
	char data;
	Node next;

	public Node(char data) {
		this.data = data;
		this.next = null;
	}
}

class LinkedList {
	Node head;
	static int length = 0;

	public Node add(char data) {
		Node Node = new Node(data);
		if (head == null) {
			head = Node;
			return head;
		}
		Node last = head;
		while (last.next != null) {
			last = last.next;
		}
		last.next = Node;
		length++;
		return head;
	}

	public Node push(char data) {
		Node Node = new Node(data);
		if (head == null) {
			head = Node;
			return head;
		}
		Node.next = head;
		head = Node;
		return Node;
	}

	public boolean isPalidrome(Node head) {
		Stack<Character> st = new Stack<Character>();
		int middle = length / 2;
		for (int index = 0; index < middle; index++) {
			st.add(head.data);
			head = head.next;
		}
		if (head == null) {
			return false;
		}
		head = head.next;
		while (st.size() > 0) {
			if (st.pop() != head.data) {
				return false;
			}
			head = head.next;
		}
		return true;
	}
}

public class Palidrome {
	public static void main(String[] args) {
		LinkedList ls = new LinkedList();
		ls.add('R');
		ls.add('A');
		ls.add('D');
		ls.add('A');
		ls.add('R');
		System.out.println(ls.isPalidrome(ls.head));
	}

}
