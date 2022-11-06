class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        int i = 0;
        while(i < n) {
            int num = nums[i];
            if(num <= 0 || num > n || nums[num-1] == num) {
                i++;
                continue;
            } 
            int newIndex = num-1;
            int temp = nums[newIndex];
            nums[newIndex] = num;
            nums[i] = temp;
        }
        
        for(i = 0; i<n; i++) {
            int num = nums[i];
            if(num != (i+1)) return i+1;
        }
        
        return n+1;
    }
}
