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

class TreeNodeDepth {
    TreeNode root;
    int depth;
    TreeNodeDepth(TreeNode root, int depth) {
        this.root = root;
        this.depth = depth;
    }   
}

class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(root == null) {
            return null;
        }
        
        if(depth == 1) {
            return new TreeNode(val, root, null);
        }
        
        Stack<TreeNodeDepth> stack = new Stack<>();
        stack.push(new TreeNodeDepth(root, 1));
        
        
        while(!stack.isEmpty()) {
            TreeNodeDepth parentNode = stack.pop();
            int parentDepth = parentNode.depth;
            TreeNode parent = parentNode.root;
            
            if(parent == null) {
                continue;
            }
            
            if(parentDepth + 1 == depth) {
                // You add the new node here
                TreeNode leftNode = new TreeNode(val, parent.left, null);
                TreeNode rightNode = new TreeNode(val, null, parent.right);
                parent.left = leftNode;
                parent.right = rightNode;
            }
            else {
                TreeNodeDepth leftChild = new TreeNodeDepth(parent.left, parentDepth + 1);
                TreeNodeDepth rightChild = new TreeNodeDepth(parent.right, parentDepth + 1);

                stack.push(leftChild);
                stack.push(rightChild);
            }
        }
        
        return root;
    }
    
    private TreeNode addOneRowHelper(TreeNode root, int val, int depth) {
        if(root == null) {
            return null;
        }
        if(depth-1 == 0) {
            TreeNode leftNode = new TreeNode(val, root.left, null);
            TreeNode rightNode = new TreeNode(val, null, root.right);
            
            root.left = leftNode;
            root.right = rightNode; 
        }
        else {
            root.left = addOneRowHelper(root.left, val, depth-1);
            root.right = addOneRowHelper(root.right, val, depth-1);
        }
         
        return root;
    }
}
