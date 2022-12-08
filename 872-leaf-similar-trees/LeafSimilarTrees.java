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
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafValues1 = new ArrayList(), leafValues2 = new ArrayList();
        
        traverseNodes(root1, leafValues1);
        traverseNodes(root2, leafValues2);
        
        if(leafValues1.size() != leafValues2.size()) return false;
        
        for(int i = 0; i < leafValues1.size(); i++) {
            if(leafValues1.get(i) != leafValues2.get(i)) return false;
        }
        
        return true;
    }
    
    private void traverseNodes(TreeNode root, List<Integer> leafValues) {
        if(root == null) return;
        
        if(root.right == null && root.left == null) {
            leafValues.add(root.val);
            return;
        }
        
        traverseNodes(root.left, leafValues);
        traverseNodes(root.right, leafValues);
    }
}
