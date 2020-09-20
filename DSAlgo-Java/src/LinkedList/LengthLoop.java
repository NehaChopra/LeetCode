//https://www.geeksforgeeks.org/find-length-of-loop-in-linked-list/
package LinkedList;

/*
 *  Floyd’s Cycle detection algorithm 
 */
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
		Node Node = new Node(data);
		if (head == null) {
			head = Node;
			return head;
		}
		Node last = head;
		while (last.next != null) {
			last = last.next;
		}
		last.next = Node;
		return head;
	}

	public Node push(int data) {
		Node Node = new Node(data);
		if (head == null) {
			head = Node;
			return head;
		}
		Node.next = head;
		head = Node;
		return Node;
	}

	public int lengthLoop(Node head) {
		int count = 0;
		if (head == null) {
			return count;
		}
		Node slow = head;
		Node fast = head;
		while (slow.next != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			count++;
			if (slow == fast) {
				return count;
			}
		}
		return count;
	}
}

public class LengthLoop {
	public static void main(String[] args) {
		LinkedList ls = new LinkedList();
		ls.add(20);
		ls.add(4);
		ls.add(15);
		ls.add(10);
		ls.head.next.next.next.next = ls.head;
		System.out.println(ls.lengthLoop(ls.head));
	}

}
