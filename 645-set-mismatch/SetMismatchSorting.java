class Solution {
    public int[] findErrorNums(int[] nums) {
        if(nums == null || nums.length < 2) {
            return new int[0];
        }
        
        int n = nums.length;
        int[] missing = new int[2];
        
        Arrays.sort(nums);
        
        for(int i = 0; i<n; i++) {
            int num = nums[i];
            int prev = i > 0 ? nums[i-1] : 0;
            if(i > 0 && prev == num) {
                missing[0] = num;
            }
            else if(num > prev+1) {
                missing[1] = num-1;
            }
        }
        
        if(nums[n-1] != n) {
            missing[1] = n;
        }
        return missing;
    }
}
