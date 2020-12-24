//https://www.geeksforgeeks.org/delete-a-linked-list-node-at-a-given-position/
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

	public Node push(int data) {
		Node node = new Node(data);
		if (head == null) {
			head = node;
			return head;
		}
		node.next = head;
		return node;
	}

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

	public void print(Node node) {
		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}

	public void deleteNodeAtPostion(int pos) {
		Node currentNode = head;
		Node prevNode = null;
		int k = 0;
		if (pos == 0) {
			head = head.next;
			return;
		}
		while (k < pos && currentNode.next != null) {
			prevNode = currentNode;
			currentNode = currentNode.next;
			k++;
		}
		if (currentNode == null || prevNode == null || currentNode.next == null || prevNode.next == null) {
			return;
		}
		prevNode.next = currentNode.next;
	}
}

public class DeleteNodeAtPositon {
	public static void main(String[] args) {
		LinkedList ls = new LinkedList();
		ls.add(8);
		ls.add(2);
		ls.add(3);
		ls.add(1);
		ls.add(7);
		ls.print(ls.head);
		ls.deleteNodeAtPostion(1);
		System.out.println();
		ls.print(ls.head);
		ls.deleteNodeAtPostion(0);
		System.out.println();
		ls.print(ls.head);
	}

}
