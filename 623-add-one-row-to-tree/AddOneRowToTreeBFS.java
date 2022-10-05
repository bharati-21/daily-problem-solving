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

class Node {
    TreeNode root;
    int depth;
    Node(TreeNode root, int depth) {
        this.root = root;
        this.depth = depth;
    }
}

class AddOneRowToTreeBFS {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(root == null) {
            return null;
        }
        
        if(depth == 1) {
            // insert root.
            return new TreeNode(val, root, null);
        }
        
        Queue<Node> queue = new LinkedList();
        queue.add(new Node(root, 1));
        
        while(!queue.isEmpty()) {
            Node parentNode = queue.poll();
            int d = parentNode.depth;
            TreeNode parent = parentNode.root;
            
            if(parent == null) {
                continue;
            }
            
            if(d+1 == depth) {
                TreeNode leftNode = new TreeNode(val, parent.left, null);
                TreeNode rightNode = new TreeNode(val, null, parent.right);
                
                parent.left = leftNode;
                parent.right = rightNode;
            }
            
            else {
                Node leftNode = new Node(parent.left, d+1);
                Node rightNode = new Node(parent.right, d+1);
                queue.add(leftNode);
                queue.add(rightNode);
            }
        }
        
        return root;
    }
}
