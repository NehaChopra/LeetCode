// https://www.geeksforgeeks.org/zigzag-tree-traversal/
// https://leetcode.com/problems/binary-tree-level-order-traversal/


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




/**
 * 
 **************************************************Leetcode***********************************************************
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//class Solution {    
//    public static int getHeight(TreeNode root){
//        if(root == null){
//            return 0;
//        }
//        int leftChildHeight = getHeight(root.left);
//        int rightChildHeight= getHeight(root.right); 
//        
//        return (Math.max(leftChildHeight, rightChildHeight) + 1);
//    }
//    
//    public static void levelOrderTraversal(TreeNode root, int level, List<Integer> traversalList){
//        if(root == null){
//            return;
//        }
//        if(level == 1){
//            traversalList.add(root.val);
//        }else{
//            levelOrderTraversal(root.left, level-1, traversalList);
//            levelOrderTraversal(root.right, level-1, traversalList);
//        }
//    }
//    
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> finalList = new ArrayList<List<Integer>>();
//        int height = getHeight(root);
//        for(int level = 1; level <= height; level++){
//            List<Integer> traversalList = new ArrayList<Integer>();
//            levelOrderTraversal(root, level, traversalList);
//            finalList.add(traversalList);
//        }
//        return finalList;
//    }
//}