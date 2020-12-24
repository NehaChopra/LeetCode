//https://www.geeksforgeeks.org/identical-linked-lists/
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

	public boolean identicalLinkedList(Node head, Node head1) {
		Node prev = null;
		Node curr = head;
		Node curr1 = head1;
		while (curr != null && curr1 != null) {
			if (curr.data != curr1.data) {
				return false;
			}
			curr = curr.next;
			curr1 = curr1.next;

		}

		return true;
	}

	public void print(Node head) {
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
}

public class IdenticalLinkedList {
	public static void main(String[] args) {
		LinkedList ls1 = new LinkedList();
		ls1.add(1);
		ls1.add(2);
		ls1.add(3);

		LinkedList ls2 = new LinkedList();
		ls2.add(1);
		ls2.add(3);
		ls2.add(3);

		System.out.println(ls1.identicalLinkedList(ls1.head, ls2.head));
	}

}
