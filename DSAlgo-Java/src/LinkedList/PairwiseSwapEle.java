//https://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list/
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

	public Node pairwiseSwap(Node head, int k) {
		Node prev = null;
		Node curr = head;
		Node next = null;
		int count = 0;

		while (count < k && curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count = count + 1;
		}
		if (curr != null) {
			head.next = pairwiseSwap(curr, k);
		}
		return prev;
	}

	public void print(Node head) {
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
}

public class PairwiseSwapEle {
	public static void main(String[] args) {
		LinkedList ls1 = new LinkedList();
		ls1.add(1);
		ls1.add(2);
		ls1.add(3);
		ls1.add(4);
		ls1.add(5);
		ls1.add(6);

		int k = 2;
		ls1.head = ls1.pairwiseSwap(ls1.head, k);
		ls1.print(ls1.head);
	}

}
