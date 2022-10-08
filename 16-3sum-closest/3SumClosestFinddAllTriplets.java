class Pair {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        
        int n = nums.length;
        int closestSum = Integer.MAX_VALUE;
        List<Pair> pairs = new ArrayList();
        
        // Find all possible pairs <i,j> TC: O(n^2)
        for(int i = 0; i<n-1; i++) {
            for(int j = i+1; j<n; j++) {
                pairs.add(new Pair(i, j));
            }
        }
        
        // For every pair <i,j>, find a k, such that i != j && i != k
        for(int k = 0; k<n; k++) {
            for(Pair p: pairs) {
                int i = p.first;
                int j = p.second; 
                if(k == i || k == j ) {
                    continue;
                }
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(target - sum);
                int closestDiff = Math.abs(target - closestSum);
                if(diff < closestDiff) {
                    closestSum = sum;
                }
            }           
        }
        
        return closestSum;
    }
}
