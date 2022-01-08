
package BFS.tree;

//https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

/**
 *********************************************************************Leetcode****************************************************************************
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
//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        List<List<Integer>> finalList = new ArrayList<List<Integer>>();
//        int height = getHeight(root);
//        for(int level = 1; level <= height; level++){
//            List<Integer> traversalList = new ArrayList<Integer>();
//            levelOrderTraversal(root, level, traversalList);
//            finalList.add(traversalList);
//        }
//        Collections.reverse(finalList);
//        return finalList;
//    }
//    
//    
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
//}
