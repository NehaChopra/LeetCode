////https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
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
//	public void intersectionPonintOfSortedLinkedList(Node head1, Node head2, int length1, int length2) {
//		int diff = (length1 > length2) ? (length1 - length2) : (length2 - length1);
//		if (length1 > length2) {
//			int count = 0;
//			while (head1 != null && count < diff) {
//				head1 = head1.next;
//				count = count + 1;
//			}
//		} else {
//			int count = 0;
//			while (head2 != null && count < diff) {
//				head2 = head2.next;
//				count = count + 1;
//			}
//		}
//		if (head1 == null || head2 == null) {
//			return;
//		}
//		while (head1 != null && head2 != null) {
//			if (head1.data == head2.data) {
//				System.out.println(head1.data);
//				break;
//			}
//			head1 = head1.next;
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
//public class IntersectPoinList {
//	public static void main(String[] args) {
//		LinkedList ls1 = new LinkedList();
//		ls1.add(3);
//		ls1.add(6);
//		ls1.add(9);
//		ls1.add(15);
//		ls1.add(30);
//
//		LinkedList ls2 = new LinkedList();
//		ls2.add(10);
//		ls2.add(15);
//		ls2.add(30);
//
//		ls1.intersectionPonintOfSortedLinkedList(ls1.head, ls2.head, ls1.length, ls2.length);
//	}
//
//}
