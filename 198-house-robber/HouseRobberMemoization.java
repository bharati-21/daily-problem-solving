class Solution {
    private int[] memo;
    public int rob(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
        
        return robHelper(nums, n-1);
    }
    
    private int robHelper(int[] nums, int index) {
        if(index < 0) return 0;
        
        // if cached result found, return it
        if(memo[index] != -1) return memo[index];
        
        // rob the current house
        int robNow = nums[index] + robHelper(nums, index-2);
        // skip robbing the current house
        // rob the previous house
        int robPrevious = robHelper(nums, index-1);
        
        // cache result
        return memo[index] = Math.max(robNow, robPrevious);
    }
}
