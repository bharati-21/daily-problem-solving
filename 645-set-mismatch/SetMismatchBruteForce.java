class Solution {
    public int[] findErrorNums(int[] nums) {
        if(nums == null || nums.length < 2) {
            return new int[0];
        }
        
        int n = nums.length;
        int[] missing = new int[2];
        
        for(int i = 1; i <= n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(nums[j] == i) {
                    count++;
                }
                if(count == 2) {
                    missing[0] = i;
                    if(missing[1] != 0) {
                        return missing;
                    }
                }
            }
            if(count == 0) {
                missing[1] = i;
                if(missing[0] != 0) {
                    return missing;
                }
            }
        }
        
        return missing;
    }
}
