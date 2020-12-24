//https://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/
package LinkedList;

import java.util.HashMap;
import java.util.Map;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

class LinkedList {
	Node head;
	int length;

	public Node add(int data) {
		length = length + 1;
		Node node = new Node(data);
		if (head == null) {
			head = node;
			return head;
		}
		Node last = head;
		while (last.next != null) {
			last = last.next;
		}
		last.next = node;
		return head;
	}

	public Node push(int data) {
		Node node = new Node(data);
		if (head == null) {
			head = node;
			return head;
		}
		node.next = head;
		head = node;
		return head;
	}

	public LinkedList addTwoNumber(Node head1, Node head2) {
		LinkedList add = new LinkedList();
		Node curr1 = head1;
		Node curr12 = head2;
		while (curr1 != null && curr12 != null) {
			
		}

		return add;
	}

	public void print(Node head) {
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
}

public class AddNumber {
	public static void main(String[] args) {
		LinkedList ls1 = new LinkedList();
		ls1.push(3);
		ls1.push(6);
		ls1.push(5);

		LinkedList ls2 = new LinkedList();
		ls1.push(2);
		ls1.push(4);
		ls1.push(8);

		LinkedList ls3 = ls1.addTwoNumber(ls1.head, ls2.head);
		ls3.print(ls3.head);
	}

}
