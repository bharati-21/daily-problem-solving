class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length <= 2) {
            return Integer.MIN_VALUE;
        }
        
        int n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[2];
        
        for(int i = 0; i<n-2; i++) {
            for(int j = i+1; j<n-1; j++) {
                for(int k = j+1; k<n; k++) {
                    int currSum = nums[i] + nums[j] + nums[k];
                    
                    if(Math.abs(currSum - target) < Math.abs(closestSum - target)) {
                        closestSum = currSum;
                    }
                }
            }
        }
        
        return closestSum;
    }
}
