//https://www.geeksforgeeks.org/find-maximum-or-minimum-in-binary-tree/
package BFS.tree;

public class MaxMinBInaryTree {

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
	
	   static int findMax(Node node)
	    {
	        if (node == null)
	            return Integer.MIN_VALUE;
	 
	        int res = node.data;
	        int lres = findMax(node.leftChild);
	        int rres = findMax(node.rightChild);
	 
	        if (lres > res)
	            res = lres;
	        if (rres > res)
	            res = rres;
	        return res;
	    }

	public static void main(String[] args) {
		MaxMinBInaryTree tree = new MaxMinBInaryTree();
		tree.root = new Node(2);
        tree.root.leftChild = new Node(7);
        tree.root.rightChild = new Node(5);
        tree.root.leftChild.rightChild = new Node(6);
        tree.root.leftChild.rightChild.leftChild = new Node(1);
        tree.root.leftChild.rightChild.rightChild = new Node(11);
        tree.root.rightChild.rightChild = new Node(9);
        tree.root.rightChild.rightChild.leftChild = new Node(4);
 
		 

		int max = findMax(tree.root);
		System.out.println(max);
	}
}
