////https://www.geeksforgeeks.org/segregate-even-and-odd-elements-in-a-linked-list/
//package LinkedList;
//
//import java.util.HashMap;
//import java.util.Map;
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
//	int length;
//
//	public Node add(int data) {
//		length = length + 1;
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
//	public Node segregateOddAndEven(Node head) {
//		Node prevOdd = null;
//		Node prevEven = null;
//		Node headOdd = null;
//		Node headEven = null;
//		Node curr = head;
//		while (curr != null) {
//			if (curr.data % 2 == 1) {
//				if (prevOdd == null) {
//					prevOdd = curr;
//					headOdd = prevOdd;
//				} else {
//					prevOdd.next = curr;
//					prevOdd = curr;
//				}
//
//			} else {
//				if (prevEven == null) {
//					prevEven = curr;
//					headEven = prevEven;
//				} else {
//					prevEven.next = curr;
//					prevEven = curr;
//				}
//			}
//			curr = curr.next;
//		}
//		prevEven.next = headOdd;
//		head = headEven;
//		prevOdd.next = null;
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
//public class SegregateEvenOdd {
//	public static void main(String[] args) {
//		LinkedList ls1 = new LinkedList();
//		ls1.add(17);
//		ls1.add(15);
//		ls1.add(8);
//		ls1.add(12);
//		ls1.add(10);
//		ls1.add(5);
//		ls1.add(4);
//		ls1.add(1);
//		ls1.add(7);
//		ls1.add(6);
//
//		ls1.head = ls1.segregateOddAndEven(ls1.head);
//		ls1.print(ls1.head);
//	}
//
//}
