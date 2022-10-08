class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length <= 2) {
            return Integer.MIN_VALUE;
        }
        
        int n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[2];
        
        Arrays.sort(nums);
        for(int outer = 0; outer < n-2; outer++) {
            int left = outer+1;
            int right = n-1;
            int outerNum = nums[outer];
            
            while(left < right) {
                int leftNum = nums[left];
                int rightNum = nums[right];
                int currSum = outerNum + leftNum + rightNum;
                
                if(currSum == target) {
                    return target;
                }    
                if(currSum > target) {
                    right--;
                }
                else {
                    left++;
                }
                
                if(Math.abs(target - currSum) < Math.abs(target-closestSum)) {
                    closestSum = currSum;
                }
            }
        }
        
        return closestSum;
    }
}
