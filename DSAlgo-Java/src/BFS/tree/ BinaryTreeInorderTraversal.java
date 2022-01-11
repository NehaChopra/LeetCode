//https://leetcode.com/problems/binary-tree-inorder-traversal/

package BFS.tree;



/**
 *********************************************************************Leetcode****************************************************************************
 * 
 * 
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
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> inOrderResult = new ArrayList<Integer>();
//        inOrder(root, inOrderResult);
//        return inOrderResult;
//    }
//        
//    public void inOrder(TreeNode root, List<Integer> inOrderResult){
//        if(root == null){
//            return;
//        }
//        inOrder(root.left, inOrderResult);
//        inOrderResult.add(root.val);
//        inOrder(root.right, inOrderResult);
//    }
//}