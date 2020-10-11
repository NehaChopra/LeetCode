////https://www.geeksforgeeks.org/remove-duplicates-from-a-sorted-linked-list/
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
//	public void removeDuplicatedFromSortedList(Node head) {
//		Node prev = head;
//		Node curr = head;
//		while (curr != null) {
//			if (prev.data == curr.data) {
//				curr = curr.next;
//			} else {
//				prev.next = curr;
//				prev = curr;
//				curr = curr.next;
//			}
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
//public class RemoveDuplicatesSortedList {
//	public static void main(String[] args) {
//		LinkedList ls = new LinkedList();
//		ls.add(11);
//		ls.add(11);
//		ls.add(11);
//		ls.add(21);
//		ls.add(43);
//		ls.add(43);
//		ls.add(60);
//		ls.removeDuplicatedFromSortedList(ls.head);
//		ls.print(ls.head);
//	}
//
//}
