////https://www.geeksforgeeks.org/swap-nodes-in-a-linked-list-without-swapping-data/
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
//	public void swapNodeWithoutSwappingData(Node head) {
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
//public class SwapNodesWithoutSwappingData {
//	public static void main(String[] args) {
//		LinkedList ls = new LinkedList();
//		ls.add(12);
//		ls.add(11);
//		ls.add(12);
//		ls.add(12);
//		ls.add(21);
//		ls.add(41);
//		ls.add(43);
//		ls.add(21);
//		ls.swapNodeWithoutSwappingData(ls.head);
//		ls.print(ls.head);
//	}
//
//}
