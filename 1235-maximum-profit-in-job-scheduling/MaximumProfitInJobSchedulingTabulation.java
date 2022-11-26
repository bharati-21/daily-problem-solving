class Solution {
    private int n;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        n = startTime.length;
        int[] dp = new int[n];
        int[][] jobs = new int[n][3];
        
        for(int i = 0; i<n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
                
        for(int index = n-1; index >= 0; index--) {
            int currStartTime = jobs[index][0];
            int currEndTime = jobs[index][1];
            int currProfit = jobs[index][2];
            
            int nextIndex = findNextIndex(index, jobs, currEndTime);
            int includeCurr = currProfit;
            if(nextIndex != -1) {
                includeCurr += dp[nextIndex];
            }
            int excludeCurr = (index == n-1) ? 0 : dp[index+1];
            
            dp[index] = Math.max(includeCurr, excludeCurr);
        }
        
        return dp[0];
    }
    
    private int findNextIndex(int index, int[][] jobs, int endTime) {        
        int start = index + 1;
        int end = n-1;
        int nextIndex = -1;

        while(start <= end) {
            int mid = (start + end) / 2;
            int midStart = jobs[mid][0];
            
            if(midStart >= endTime) {
                nextIndex = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        
        return nextIndex;
    }
}
