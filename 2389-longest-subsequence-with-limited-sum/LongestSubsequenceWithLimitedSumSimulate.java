class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int m = queries.length, n = nums.length;
        int[] maxSizes = new int[m];
        Arrays.sort(nums);
        
        for(int i = 0; i < m; i++) {
            int query = queries[i];
            int sum = 0;
            int j = 0;
            while(j < n) {
                sum += nums[j];
                if(sum > query) {
                    break;
                }
                j++;
            }
            
            maxSizes[i] = j;
        }
        
        
        return maxSizes;
    }
}
