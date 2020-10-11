////https://www.geeksforgeeks.org/remove-duplicates-from-an-unsorted-linked-list/
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
//	public void removeDuplicatedFromUnSortedList(Node head) {
//		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
//		Node prev = head;
//		hm.put(prev.data, 1);
//		Node curr = head.next;
//		while (curr != null) {
//			if (hm.containsKey(curr.data)) {
//				prev.next = curr.next;
//			} else {
//				hm.put(curr.data, 1);
//				prev = curr;
//			}
//
//			curr = curr.next;
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
//public class RemoveDuplicatesUnSortedList {
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
//		ls.removeDuplicatedFromUnSortedList(ls.head);
//		ls.print(ls.head);
//	}
//
//}
