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
    public int maxAncestorDiff(TreeNode root) {
        return maxAncestorDiffHelper(root, root.val, root.val);
    }
    
    private int maxAncestorDiffHelper(TreeNode root, int max, int min) {
        if(root == null) {
            System.out.println(max + " " + min + " " + Math.abs(max - min));
            return Math.abs(max - min);
        };
        
        int val = root.val;
        max = Math.max(val, max);
        min = Math.min(val, min);
        
        int leftMax = maxAncestorDiffHelper(root.left, max, min);
        int rightMax = maxAncestorDiffHelper(root.right, max, min);
        
        
        
        return Math.max(leftMax, rightMax);
    }
}
