//https://www.geeksforgeeks.org/delete-nodes-which-have-a-greater-value-on-right-side/
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

	public Node deleteNodeWhichHasGreaterValueOnRight(Node head) {
		Node prev = null;
		Node changeHead = null;
		Node curr = head;
		Node next = null;
		while (curr != null && curr.next != null) {
			next = curr.next;
			if (curr.data < next.data) {
				curr = next;
				if (prev != null) {
					prev.next = curr;
				}
			} else {
				if (prev == null) {
					changeHead = curr;
				}
				prev = curr;
				curr = next;
			}
		}

		return changeHead;
	}

	public void print(Node head) {
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
}

public class DeleteNodeGreaterValueOnRight {
	public static void main(String[] args) {
		LinkedList ls1 = new LinkedList();
		ls1.add(12);
		ls1.add(15);
		ls1.add(10);
		ls1.add(11);
		ls1.add(5);
		ls1.add(6);
		ls1.add(2);
		ls1.add(3);

		ls1.head = ls1.deleteNodeWhichHasGreaterValueOnRight(ls1.head);
		ls1.print(ls1.head);
	}

}
