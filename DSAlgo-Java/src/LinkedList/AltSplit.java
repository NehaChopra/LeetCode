//https://www.geeksforgeeks.org/alternating-split-of-a-given-singly-linked-list/
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

	public Node alternateSplitOfLinkedList(Node head) {
		Node head1 = head;
		Node prev = null;
		Node curr = head;
		Node next = null;

		return head1;
	}

	public void print(Node head) {
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
}

public class AltSplit {
	public static void main(String[] args) {
		LinkedList ls1 = new LinkedList();
		ls1.add(0);
		ls1.add(1);
		ls1.add(0);
		ls1.add(1);
		ls1.add(0);
		ls1.add(1);

		LinkedList ls2 = ls1;
		ls1.print(ls1.alternateSplitOfLinkedList(ls1.head));
		ls1.print(ls1.alternateSplitOfLinkedList(ls1.head.next));
	}

}
