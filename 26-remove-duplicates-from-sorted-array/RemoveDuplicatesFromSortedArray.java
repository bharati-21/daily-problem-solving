class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        int k = 0;
        int i = 1;
        while(i < n) {
            if(nums[i] != nums[k]) {
                nums[++k] = nums[i++];
            } 
            else {
                i++;
            }
        }
        
        return k+1;
    }
}
