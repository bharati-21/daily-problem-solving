class Solution {
    public int minimumAverageDifference(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        long prefixSum = 0;
        long total = 0;
        long minAverageDiff = Integer.MAX_VALUE;
        int minAvgIndex = -1;
        
        for(int num: nums) {
            total += num;
        }
        
        for(int i = 0; i<n; i++) {
            prefixSum += (long) nums[i];
            long right = (total - prefixSum);
            
            long leftAvg = prefixSum / (i+1); 
            long rightAvg = 0;
            if(i+1 != n) {
                rightAvg = right / (n-i-1);
            }
            
            long diff = Math.abs(leftAvg - rightAvg);
            
            if(diff < minAverageDiff) {
                minAvgIndex = i;
                minAverageDiff = diff;
            }
        }
        
        return minAvgIndex;
    }
}
