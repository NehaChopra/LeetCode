//https://leetcode.com/problems/binary-tree-preorder-traversal/

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
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> preOrderResult = new ArrayList<Integer>();
//        preOrder(root, preOrderResult);
//        return preOrderResult;        
//    }
//    
//        
//    public void preOrder(TreeNode root, List<Integer> preOrderResult){
//        if(root == null){
//            return;
//        }
//        preOrderResult.add(root.val);
//        preOrder(root.left, preOrderResult);
//        preOrder(root.right, preOrderResult);
//    }
//}