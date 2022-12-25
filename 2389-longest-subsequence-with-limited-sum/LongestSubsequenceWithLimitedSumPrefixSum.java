class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int m = queries.length, n = nums.length;
        
        int[] maxSizes = new int[m];
        int[] prefixSum = new int[n];
        Arrays.sort(nums);
        
        prefixSum[0] = nums[0];
        for(int i = 1; i < n; i++) {
            int num = nums[i];
            prefixSum[i] = nums[i] + prefixSum[i-1];
        }
        
        for(int i = 0; i < m; i++) {
            int query = queries[i];
            
            int maxSize = binarySearch(prefixSum, query);
            maxSizes[i] = maxSize;
        }
        
        return maxSizes;
    }
    
    private int binarySearch(int[] nums, int target) {
        int n = nums.length;
        int start = 0, end = n-1;
        int answer = -1;
        
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == target) {
                return mid + 1;
            }
            if(nums[mid] > target) {
                end = mid - 1;
            }
            else {
                answer = mid;
                start = mid + 1;
            }
        }
        if(answer == -1) return 0;
        
        return end + 1;
    }
}
