//https://www.geeksforgeeks.org/level-order-tree-traversal/
package trees;

public class DFSTree {

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

	public static void DFS(Node root) {
		printPreOrderTraversal(root);
		System.out.println("******************************************************************************");
		printInOrderTraversal(root);
		System.out.println("******************************************************************************");
		printPostOrderTraversal(root);
	}

	public static void printPreOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		System.out.println(root.data);
		printPreOrderTraversal(root.leftChild);
		printPreOrderTraversal(root.rightChild);
	}

	public static void printInOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		printInOrderTraversal(root.leftChild);
		System.out.println(root.data);
		printInOrderTraversal(root.rightChild);
	}

	public static void printPostOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		printPostOrderTraversal(root.leftChild);
		printPostOrderTraversal(root.rightChild);
		System.out.println(root.data);
	}

	public static void main(String[] args) {
		DFSTree tree = new DFSTree();
		tree.root = new Node(1);
		tree.root.leftChild = new Node(2);
		tree.root.rightChild = new Node(3);
		tree.root.leftChild.leftChild = new Node(4);
		tree.root.leftChild.rightChild = new Node(5);

		DFS(tree.root);
	}
}
