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
 
class AddOneRowToTreeDFSRecursive {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        // If no node found
        if(root == null) {
            return new TreeNode(val);
        }
        
        // Insert at root as there's no depth = 0.
        // Make the left subtree of the new root as previous root
        if(depth == 1) {
            return new TreeNode(val, root, null);
        }
        
        return addOneRowHelper(root, val, depth-1);
    }
    
    private TreeNode addOneRowHelper(TreeNode root, int val, int depth) {
        // If the root is null, just return null
        if(root == null) {
            return null;
        }
        
        // If you are at depth-1, then this node is the parent of new nodes
        if(depth-1 == 0) {
            TreeNode leftNode = new TreeNode(val, root.left, null);
            TreeNode rightNode = new TreeNode(val, null, root.right);
            
            root.left = leftNode;
            root.right = rightNode; 
        }
        // If not, then traverse left sub tree and right subtree until depth-1 == 0
        else {
            root.left = addOneRowHelper(root.left, val, depth-1);
            root.right = addOneRowHelper(root.right, val, depth-1);
        }
         
        return root;
    }
}
