class Solution {
    public int[] findErrorNums(int[] nums) {
        if(nums == null || nums.length < 2) {
            return new int[0];
        }
        
        int n = nums.length;
        int[] missing = new int[2];
        
        Map<Integer, Integer> frequency = new HashMap();
        
        for(int i = 0; i<n; i++) {
            int num = nums[i];
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        
        for(int i = 1; i <= n; i++) {
            if(!frequency.containsKey(i)) {
                missing[1] = i;
            }
            else if(frequency.get(i) == 2) {
                missing[0] = i;
            }
        }
        
        return missing;
    }
}
