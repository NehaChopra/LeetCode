//https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

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
//    public int getMinimumDifference(TreeNode root) {
//        int height = getHeight(root);
//        
//        List<Integer> minAbsDiff = new ArrayList<Integer>();
//        for(int level = 1; level <= height; level++){
//            levelOrderTraversal(root, level, new ArrayList<Integer>() , minAbsDiff);
//        }
//        return getMinAbsDiff(minAbsDiff);
//    }
//    public int getMinAbsDiff(List<Integer> minAbsDiff){
//        int min = Integer.MAX_VALUE;
//        for(int index=0; index<minAbsDiff.size(); index++){
//            if(minAbsDiff.get(index) < min){
//                min = minAbsDiff.get(index);
//            }
//        }
//        return min;
//    }
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
//    public static void levelOrderTraversal(TreeNode root, int level, List<Integer> prevNodeValue, List<Integer> minAbsDiff){
//        if(root == null){
//            return;
//        }
//        if(level == 1){
//            if(prevNodeValue != null){
//                for(int index=0; index<prevNodeValue.size(); index++){
//                    minAbsDiff.add(Math.abs(prevNodeValue.get(index) - root.val));   
//                }
//            }
//        }else{
//            prevNodeValue.add(root.val);
//            levelOrderTraversal(root.left, level-1,prevNodeValue , minAbsDiff);
//            // prevNodeValue.add(root.val);
//            levelOrderTraversal(root.right, level-1, prevNodeValue, minAbsDiff);
//        }
//    }
//}