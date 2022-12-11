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
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        
        helper(root);
        
        return maxSum;
    }
    
    private int helper(TreeNode root) {
        if(root == null) return 0;
        
        int left = helper(root.left);
        if(left < 0) left = 0;
        int right = helper(root.right);
        if(right < 0) right = 0;
        int val = root.val;
        maxSum = Math.max(maxSum, left + right + val);
        
        return val + Math.max(left, right);
    }
}
