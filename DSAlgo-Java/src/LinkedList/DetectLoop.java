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
	private Node head;

	public void push(int data) {
		Node node = new Node(data);
		node.next = node;
		head = node;
	}
}

public class DetectLoop {
	public static void main(String[] args) {

	}

}
