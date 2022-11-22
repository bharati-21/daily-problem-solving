class Solution {
    public int numSquares(int n) {
        if(n <= 0) return 0;
        
        int[] dp = new int[n+1];
        dp[0] = 0;
        
        for(int i = 1; i<=n; i++) {
            int answer = Integer.MAX_VALUE;
            
            for(int j = 1; j<=Math.sqrt(i); j++) {
                int nextNum = i - (j * j);
                if(nextNum < 0) {
                    continue;
                }
                
                int nextAnswer = dp[nextNum];
                answer = Math.min(answer, nextAnswer);
            }
            
            dp[i] = answer + 1;
        }
        return dp[n];
    }
}
