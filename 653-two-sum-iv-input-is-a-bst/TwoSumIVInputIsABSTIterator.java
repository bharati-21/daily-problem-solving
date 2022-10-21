class BSTInorder {
    private Stack<TreeNode> left, right;

    BSTInorder(TreeNode root) {
        left = new Stack();
        right = new Stack();
        pushAllLeft(root);
        pushAllRight(root);
    }

    private void pushAllLeft(TreeNode root) {
        TreeNode temp = root;
        while(temp != null) {
            left.push(temp);
            temp = temp.left;
        }
    }

    private void pushAllRight(TreeNode root) {
        TreeNode temp = root;
        while(temp != null) {
            right.push(temp);
            temp = temp.right;
        }
    }

    private int next() {
        TreeNode top = left.pop();
        pushAllLeft(top.right);
        return top.val;
    }

    private int before() {
        TreeNode top = right.pop();
        pushAllRight(top.left);
        return top.val;
    }

    public boolean findTarget(int k) {
        int l = next();
        int r = before();
        while(l < r) {
            int sum = l+r;
            if(sum == k) {
                return true;
            }
            if(sum > k) {
                r = before();
            }
            else {
                l = next();
            }
        }
        return false;
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTInorder bstInorder = new BSTInorder(root);
        return bstInorder.findTarget(k);
    }
}
