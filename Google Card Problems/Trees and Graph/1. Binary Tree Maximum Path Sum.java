/**
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
class Solution {
    private int maxValue;
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        getGainOfNode(root);
        return maxValue;
    }
    
    private int getGainOfNode(TreeNode node){
        // base case         
        if(node == null)
            return 0;
        
        //  copmart gain value with zero, means if gainvalue < 0 , we will not take this path         
        int leftGain = Math.max(getGainOfNode(node.left),0);
        int rightGain = Math.max(getGainOfNode(node.right),0);
        
        int pathValue = leftGain + rightGain + node.val;
        maxValue = Math.max(maxValue, pathValue);
        
        // i need to return the max of 2 paths to the parent, to calculte the right max path          
        return node.val + Math.max(leftGain, rightGain);
    }

    
}
