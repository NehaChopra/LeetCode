//https://www.geeksforgeeks.org/print-reverse-of-a-linked-list-without-actually-reversing/
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

	public void printReverseLinkedList(Node head) {

	}

	public void print(Node head) {
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
}

public class PrintReverseLinkedList {
	public static void main(String[] args) {
		LinkedList ls1 = new LinkedList();
		ls1.add(1);
		ls1.add(2);
		ls1.add(3);
		ls1.add(4);

		ls1.printReverseLinkedList(ls1.head);
	}

}
