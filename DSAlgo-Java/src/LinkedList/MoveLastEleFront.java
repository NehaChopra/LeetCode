////https://www.geeksforgeeks.org/move-last-element-to-front-of-a-given-linked-list/
//package LinkedList;
//
//import java.util.HashMap;
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
//	public Node moveLastElementToFront(Node head) {
//		Node prev = null;
//		Node curr = head;
//		while (curr.next != null) {
//			prev = curr;
//			curr = curr.next;
//		}
//		prev.next = curr.next;
//		curr.next = head;
//		head = curr;
//		return head;
//	}
//
//	public void print(Node head) {
//		while (head != null) {
//			System.out.println(head.data);
//			head = head.next;
//		}
//	}
//}
//
//public class MoveLastEleFront {
//	public static void main(String[] args) {
//		LinkedList ls = new LinkedList();
//		ls.add(1);
//		ls.add(2);
//		ls.add(3);
//		ls.add(4);
//		ls.add(5);
//		ls.head = ls.moveLastElementToFront(ls.head);
//		ls.print(ls.head);
//	}
//
//}
