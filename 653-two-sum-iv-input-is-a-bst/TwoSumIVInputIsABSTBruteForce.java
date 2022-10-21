class Solution {
  public boolean findTarget(TreeNode root, int k) {
      return dfs(root, root, k);
  }

  // You need to maintain the startNode for whose complement you're searching 
  // Since every search for the complement would begin from the root,
  // You need to avoid comparing with the same node again
  private boolean dfs(TreeNode root, TreeNode startNode, int target) {
      if(startNode == null) {
          return false;
      }
      // Now search for the complement of this node
      boolean result = search(root, startNode, target-startNode.val);
      if(result) {
          return true;
      }

      return dfs(root, startNode.left, target) || 
        dfs(root, startNode.right, target);
  }

  private boolean search(TreeNode root, TreeNode startNode, int target) {
      if(root == null) {
          return false;
      }

      if(root.val == target && root != startNode) {
          return true;
      }
      if(target < root.val) {
          return search(root.left, startNode, target);
      }
      return search(root.right, startNode, target);
  }
}
