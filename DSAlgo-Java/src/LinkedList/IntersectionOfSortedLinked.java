////https://www.geeksforgeeks.org/intersection-of-two-sorted-linked-lists/
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
//	public void intersectionOfSortedLinkedList(Node head1, Node head2) {
//		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
//		while (head1 != null) {
//			if (hm.containsKey(head1.data)) {
//				hm.put(head1.data, hm.get(head1.data) + 1);
//			} else {
//				hm.put(head1.data, 1);
//			}
//			head1 = head1.next;
//		}
//
//		while (head2 != null) {
//			if (hm.containsKey(head2.data)) {
//				System.out.println(head2.data);
//			}
//			head2 = head2.next;
//		}
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
//public class IntersectionOfSortedLinked {
//	public static void main(String[] args) {
//		LinkedList ls1 = new LinkedList();
//		ls1.add(1);
//		ls1.add(2);
//		ls1.add(3);
//		ls1.add(4);
//		ls1.add(6);
//
//		LinkedList ls2 = new LinkedList();
//		ls2.add(2);
//		ls2.add(4);
//		ls2.add(6);
//		ls2.add(8);
//
//		ls1.intersectionOfSortedLinkedList(ls1.head, ls2.head);
//	}
//
//}
