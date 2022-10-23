class Solution {
    public int[] findErrorNums(int[] nums) {
        if(nums == null || nums.length < 2) {
            return new int[0];
        }
        
        int n = nums.length;
        int[] missing = new int[2];
        
        int i = 0;
        while(i < n) {
            int num = nums[i];
            int index = num-1;
            if(nums[index] != num) {
                // update the index
                int temp = nums[index];
                nums[i] = temp;
                nums[index] = num;
            }
            else {
                i++;
            }
        }
                
        i = 0;
        while(i < n) {
            int num = nums[i];
            int index = num-1;
            
            if(num != i+1) {
                missing[0] = num;
                missing[1] = i+1;
                break;
            }
            i++;
        }
        
        return missing;
    }
}
