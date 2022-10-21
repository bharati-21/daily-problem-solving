class Solution {
    public int largestPerimeter(int[] nums) {
        if(nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = n-3; i>=0; i--) {
            int a = nums[i];
            int b = nums[i+1];
            int c = nums[i+2];
            if((a + b) > c) {
                return a + b + c;
            }
        }

        return 0;
    }
}
