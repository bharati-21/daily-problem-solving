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
    private long maxProduct = 0;
    private long totalSum = 0;

    public int maxProduct(TreeNode root) {
        totalSum = getSum(root);
        getSum(root);
        
        return (int) (maxProduct % (1e9 + 7));
    }
    
    private long getSum(TreeNode root) {
        if(root == null) return 0;
        
        long leftSum = getSum(root.left);
        long rightSum = getSum(root.right);
        
        long sum = leftSum + rightSum + root.val;
        // remove this current node
        long product = (totalSum - sum) * sum;
        maxProduct = Math.max(product, maxProduct);
        return sum;
    }
}
