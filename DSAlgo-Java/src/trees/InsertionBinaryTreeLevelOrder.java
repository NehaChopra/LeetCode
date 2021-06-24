//https://www.geeksforgeeks.org/insertion-in-a-binary-tree-in-level-order/
package trees;

import java.util.LinkedList;

public class InsertionBinaryTreeLevelOrder {

	Node root;

	static class Node {
		int data;
		Node leftChild;
		Node rightChild;

		Node(int data) {
			this.data = data;
			this.leftChild = null;
			this.rightChild = null;
		}
	}

	static public Node insert(Node root, int data) {
		if (root == null) {
			root = new Node(data);
			return root;
		}
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node temp = queue.pop();
			Node leftChild = temp.leftChild;
			Node rightChild = temp.rightChild;

			if (leftChild == null) {
				temp.leftChild = new Node(data);
				break;
			} else {
				queue.add(leftChild);
			}
			if (rightChild == null) {
				temp.rightChild = new Node(data);
				break;
			} else {
				queue.add(rightChild);
			}
		}
		return root;
	}

	public static void printInorderTraversal(Node root) {
		if (root == null)
			return;
		printInorderTraversal(root.leftChild);
		System.out.println(root.data);
		printInorderTraversal(root.rightChild);
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.leftChild = new Node(11);
		root.leftChild.leftChild = new Node(7);
		root.rightChild = new Node(9);
		root.rightChild.leftChild = new Node(15);
		root.rightChild.rightChild = new Node(8);

		printInorderTraversal(root);

		int key = 12;
		insert(root, key);

		printInorderTraversal(root);

	}
}
