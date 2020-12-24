//https://www.geeksforgeeks.org/linked-list-set-3-deleting-node/
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
		head = node;
		return head;
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
		if (node != null) {
			while (node != null) {
				System.out.println(node.data);
				node = node.next;
			}
		}
	}

	public void deleteNode(int data) {
		Node currNode = head;
		Node prevNode = null;
		if (currNode != null && currNode.data == data) {
			currNode = head.next;
			head = currNode;
			return;
		}
		while (currNode.next != null && currNode.data != data) {
			prevNode = currNode;
			currNode = currNode.next;
		}
		if (currNode == null)
			return;

		prevNode.next = currNode.next;
	}
}

public class DeleteNode {
	public static void main(String[] args) {
		LinkedList ls = new LinkedList();
		ls.add(2);
		ls.add(3);
		ls.add(1);
		ls.add(7);
		ls.print(ls.head);
	}

}
