//https://www.geeksforgeeks.org/level-order-tree-traversal/
package BFS.tree;

public class BFSTree {

	Node root;

	static class Node {
		int data;
		Node leftChild;
		Node rightChild;

		public Node(int data) {
			this.data = data;
			this.leftChild = null;
			this.rightChild = null;
		}
	}

	public static void BFS(Node root) {
		int height = getHeight(root);
		for (int index = 1; index <= height; index++) {
			printLevelOrderTraversal(root, index);
		}
	}

	public static void printLevelOrderTraversal(Node root, int level) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.println(root.data);
		} else {
			printLevelOrderTraversal(root.leftChild, level - 1);
			printLevelOrderTraversal(root.rightChild, level - 1);
		}
	}

	public static int getHeight(Node root) {
		if (root == null) {
			return 0;
		}
		int leftChildHeight = getHeight(root.leftChild);
		int rightChildHeight = getHeight(root.rightChild);

		return (Math.max(leftChildHeight, rightChildHeight) + 1);

	}

	public static void main(String[] args) {
		BFSTree tree = new BFSTree();
		tree.root = new Node(1);
		tree.root.leftChild = new Node(2);
		tree.root.rightChild = new Node(3);
		tree.root.leftChild.leftChild = new Node(4);
		tree.root.leftChild.rightChild = new Node(5);

		BFS(tree.root);
	}
}
