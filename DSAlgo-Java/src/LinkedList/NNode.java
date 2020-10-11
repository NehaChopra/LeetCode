//package LinkedList;
//
////https://www.geeksforgeeks.org/write-a-function-to-get-nth-node-in-a-linked-list/
//
//class Node {
//	int data;
//	Node next;
//
//	public Node(int data) {
//		this.data = data;
//		this.next = null;
//	}
//}
//
//class LinkedList {
//	Node head;
//	int size = 1;
//
//	public Node push(int data) {
//		Node node = new Node(data);
//		if (head == null) {
//			head = node;
//			return head;
//		}
//		node.next = head;
//		size++;
//		return node;
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
//		size++;
//		return head;
//	}
//
//	public Node nNode(int pos) {
//		if (pos >= size) {
//			return null;
//		}
//		Node currNode = head;
//		for (int index = 0; index < pos && currNode.next != null; index++) {
//			currNode = currNode.next;
//		}
//		System.out.println(currNode.data);
//		return currNode;
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
//}
//
//public class NNode {
//	public static void main(String[] args) {
//		LinkedList ls = new LinkedList();
//		ls.add(1);
//		ls.add(10);
//		ls.add(30);
//		ls.add(40);
////		ls.print(ls.head);
//		Node currNode = ls.nNode(4);
//	}
//}
//
//
