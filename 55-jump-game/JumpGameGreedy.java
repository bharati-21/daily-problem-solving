class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        
        int maxJump = nums[n-1];
        int target = n-1;
        int i = n-1;
        
        while(i >= 0) {
            int jump = nums[i];
            if(i + jump >= target) {
                target = i;
            }
            i--;
        }
        
        return target == 0;
    }
}
