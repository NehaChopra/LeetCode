////https://www.geeksforgeeks.org/search-an-element-in-a-linked-list-iterative-and-recursive/
//package LinkedList;
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
//			return;
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
//	public boolean searchNode(int data) {
//		Node currNode = head;
//		while (currNode.next != null && currNode.data != data) {
//			currNode = currNode.next;
//		}
//
//		if (currNode.data == data) {
//			return true;
//		}
//
//		return false;
//	}
//}
//
//public class SearchAnElement {
//	public static void main(String[] args) {
//		LinkedList ls = new LinkedList();
//		ls.add(10);
//		ls.add(20);
//		ls.add(11);
//		ls.add(12);
//		ls.add(14);
//		ls.print(ls.head);
//		System.out.println(ls.searchNode(14));
//	}
//
//}
