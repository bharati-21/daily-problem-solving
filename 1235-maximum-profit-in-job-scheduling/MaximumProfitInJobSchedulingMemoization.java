class Solution {
    private int n;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        n = startTime.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        
        int[][] jobs = new int[n][3];
        for(int i = 0; i<n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        return jobSchedulingHelper(0, jobs, memo);
    }
    
    private int jobSchedulingHelper(int index, int[][] jobs, int[] memo) {
        if(index >= n) return 0;
        
        if(memo[index] != -1) return memo[index];
        
        int currStartTime = jobs[index][0];
        int currEndTime = jobs[index][1];
        int currProfit = jobs[index][2];
        
        // choose the next index
        int nextIndex = findNextIndex(index, jobs, currEndTime);
        
        int includeCurr = currProfit;
        if(nextIndex != -1) {
            includeCurr += jobSchedulingHelper(nextIndex, jobs, memo);
        }
        int excludeCurr = jobSchedulingHelper(index+1, jobs, memo);
        
        return memo[index] = Math.max(includeCurr, excludeCurr);
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

/*
- At every index, you can either choose or not choose the job
- If you choose the current index, add it and then start with next
*/
