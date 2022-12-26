class Solution {
    private int[] memo;
    private int n;
    public boolean canJump(int[] nums) {
        n = nums.length;
        
        memo = new int[n];
        return canJumpHelper(nums, 0);
    }
    
    private boolean canJumpHelper(int[] nums, int index) {
        if(index >= n-1) {
            return true;
        }
        
        if(memo[index] != 0) {
            return (memo[index] == 1) ? true : false;
        }
        
        int jump = nums[index];
        
        for(int i = 1; i<=jump; i++) {
            boolean canReach = canJumpHelper(nums, index+i);
            if(canReach) {
                memo[index] = 1;
                return true;
            }
        }
        
        memo[index] = 2;
        return false;
    }
}
