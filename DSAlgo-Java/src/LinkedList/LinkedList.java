//package LinkedList;
//
//public class LinkedList {
//	Node head;
//
//	public Node push(int data) {
//		Node node = new Node(data);
//		if (head == null) {
//			head = node;
//			return head;
//		}
//		node.next = head;
//		head = node;
//		return head;
//	}
//
//	public Node add(int data) {
//		Node node = new Node(data);
//		if (head == null) {
//			head = node;
//			return head;
//		}
//		Node last = head;
//		while (last.next != null) {
//			last = last.next;
//		}
//		last.next = node;
//		return head;
//	}
//
//	public void print(Node node) {
//		if (node != null) {
//			while (node != null) {
//				System.out.println(node.data);
//				node = node.next;
//			}
//		}
//	}
//
//	public void deleteNode(int data) {
//		Node currNode = head;
//		Node prevNode = null;
//		if (currNode != null && currNode.data == data) {
//			currNode = head.next;
//			head = currNode;
//		}
//		while (currNode.next != null && currNode.data != data) {
//			prevNode = currNode;
//			currNode = currNode.next;
//		}
//		if (currNode == null)
//			return;
//
//		prevNode.next = currNode.next;
//	}
//	
//	public void deleteNodeAtPostion(int pos) {
//		Node currentNode = head;
//		Node prevNode = null;
//		int k = 0;
//		if (pos == 0) {
//			head = head.next;
//			return;
//		}
//		while (k != pos && currentNode.next != null) {
//			currentNode = currentNode.next;
//			prevNode = currentNode;
//			k++;
//		}
//		if (currentNode == null || prevNode == null) {
//			return;
//		}
//		prevNode.next = currentNode.next;
//	}
//
//
//}