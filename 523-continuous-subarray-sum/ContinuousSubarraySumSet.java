class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        
        int n = nums.length;
        
        int[] prefix = new int[n+1];
        for(int i = 1; i<=n; i++) {
            prefix[i] = prefix[i-1] + nums[i-1];
        }
                
        Set<Integer> set = new HashSet();
        for(int i = 2; i<=n; i++) {
            int prevMod = prefix[i-2] % k;
            set.add(prevMod);
            int mod = prefix[i] % k;
            if(set.contains(mod)) {
                return true;
            }
        }
        
        return false;
    }
}
// 0 23 25 29 35 42
