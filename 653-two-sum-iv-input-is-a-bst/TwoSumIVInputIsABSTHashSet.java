class Solution {
    HashSet<Integer> seen;
    public boolean findTarget(TreeNode root, int k) {
        seen = new HashSet();
        return dfs(root, k);
    }

    private boolean dfs(TreeNode root, int target) {
        if(root == null) {
            return false;
        }

        if(seen.contains(target - root.val)) {
            return true;
        }
        seen.add(root.val);
        return dfs(root.left, target) || dfs(root.right, target);
    }   
 } 
}
