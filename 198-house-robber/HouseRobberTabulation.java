class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        
        for(int i = 0; i<n; i++) {
            int curr = nums[i];
            // rob the current house
            int robNow = curr;
            // If there exists a previous house, 
            // use the money robbed there
            if(i-2 >= 0) {
                robNow += dp[i-2];
            }
            
            // don't rob the current house
            int robPrevious = 0;
            // If there exists a previous house,
            // use the money robbed there
            if(i-1 >= 0) {
                robPrevious = dp[i-1];
            }
            
            // tabulate the max of the money robbed so far
            dp[i] = Math.max(robNow, robPrevious);
        }
        
        return dp[n-1];
    }
}
