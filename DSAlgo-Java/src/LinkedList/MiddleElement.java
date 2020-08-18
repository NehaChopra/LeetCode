//https://www.geeksforgeeks.org/detect-loop-in-a-linked-list/
package LinkedList;

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

	public Node add(int data) {
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
		return node;
	}

	public Node middleElement(Node head) {
		if (head == null) {
			return null;
		}
		Node slow = head;
		Node fast = head;
		while (slow.next != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		if (slow == null) {
			return null;
		}
		return slow;
	}
}

public class MiddleElement {
	public static void main(String[] args) {
		LinkedList ls = new LinkedList();
		ls.add(10);
		ls.add(20);
		ls.add(11);
		ls.add(12);
		ls.add(14);
		Node middle = ls.middleElement(ls.head);
		System.out.println(middle.data);
	}

}
