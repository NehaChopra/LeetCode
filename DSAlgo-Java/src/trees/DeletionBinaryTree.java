/*
 * https://www.geeksforgeeks.org/deletion-binary-tree/
 * 
 * Given a binary tree, delete a node from it by making sure that tree shrinks from the bottom (i.e. the deleted node is replaced by bottom most and rightmost node). This is different from BST deletion. Here we do not have any order among elements, so we replace with last element.
Examples :

Delete 10 in below tree
       10
     /    \         
    20     30
Output :    
       30
     /             
    20     


Delete 20 in below tree
       10
     /    \         
    20     30
            \
            40
Output :    
       10
     /   \             
    40    30   
 */
package trees;

import java.util.LinkedList;
import java.util.Queue;

public class DeletionBinaryTree {

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

	static public Node findRightMostNode(Node root, Node lastNode) {
		if (root == null || lastNode == null) {
			return root;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node tempNode = queue.poll();
			if (tempNode == lastNode) {
				tempNode.rightChild = null;
				return root;
			}
			if (tempNode.rightChild != null) {
				queue.add(tempNode.rightChild);
			}
		}
		return root;
	}

	static public Node deleteAndReplace(Node root, int key) {
		if (root == null) {
			return root;
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		Node nodeToDelete = null;
		Node lastRightNode = null;
		Node lastRightBeforeNode = null;

		while (!queue.isEmpty()) {
			Node tempNode = queue.poll();
			if (tempNode.data == key) {
				nodeToDelete = tempNode;
			}
			if (tempNode.leftChild != null) {
				queue.add(tempNode.leftChild);
			}
			if (tempNode.rightChild != null) {
				lastRightNode = tempNode.rightChild;
				lastRightBeforeNode = tempNode;
				queue.add(tempNode.rightChild);
			}
		}
		if (nodeToDelete == null || lastRightNode == null) {
			return root;
		}
		findRightMostNode(root, lastRightBeforeNode);
		nodeToDelete.data = lastRightNode.data;
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
		root.leftChild.rightChild = new Node(12);
		root.rightChild = new Node(9);
		root.rightChild.leftChild = new Node(15);
		root.rightChild.rightChild = new Node(8);

		printInorderTraversal(root);

		int key = 19;
		deleteAndReplace(root, key);

		printInorderTraversal(root);

	}
}
