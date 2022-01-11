//https://leetcode.com/problems/binary-tree-postorder-traversal/

package BFS.tree;



/**
 *********************************************************************Leetcode****************************************************************************
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
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> postOrderResult = new ArrayList<Integer>();
//        postOrder(root, postOrderResult);
//        return postOrderResult;
//    }
//    
//    public void postOrder(TreeNode root, List<Integer> postOrderResult){
//        if(root == null){
//            return;
//        }
//        postOrder(root.left, postOrderResult);
//        postOrder(root.right, postOrderResult);
//        postOrderResult.add(root.val);
//    }    
//}