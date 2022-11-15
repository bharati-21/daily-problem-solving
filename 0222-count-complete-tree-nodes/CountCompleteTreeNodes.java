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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        
        int height = 1;
        TreeNode left = root.left, right = root.right;
        
        while(left != null && right != null) {
            height++;
            left = left.left;
            right = right.right;
        }
        
        if(left == null && right == null) {
            return (int) Math.pow(2, height) - 1;
        }
        
        return 1 + countNodes(root.right) + countNodes(root.left);
    }
}
