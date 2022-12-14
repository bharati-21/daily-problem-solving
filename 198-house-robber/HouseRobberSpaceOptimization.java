class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        // Edge cases: when there are 1 or 2 houses
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        
        int[] dp = new int[n];
        // dp[0] represents robbing the first house
        // dp[1] represents robbing either the first or second house
        int first = nums[0], second = Math.max(nums[0], nums[1]);
    
        
        for(int i = 2; i<n; i++) {
            int curr = nums[i];
            // rob now with the help of i-2 house
            int robNow = curr + first;
            
            // what is beneficial?
            // robbing this house or not robbing this house?
            int max = Math.max(robNow, second);

            // update the i-2 and i-1 max values
            first = second;
            second = max;
        }
        
        return second;
    }
}
