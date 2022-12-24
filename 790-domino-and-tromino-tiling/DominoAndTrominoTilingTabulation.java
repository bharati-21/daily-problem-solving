class Solution {
    int mod = (int) (1e9 + 7);
    public int numTilings(int n) {
        if(n == 0) return 0;
        if(n <= 2) return n;
        
        long[] dp = new long[n+1];
        long[] tromino = new long[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        tromino[0] = 0;
        tromino[1] = 1;
        tromino[2] = 2;
        
        for(int i = 3; i<=n; i++) {
            dp[i] = (dp[i-1] + dp[i-2] + 2 * tromino[i-2]) % mod;
            tromino[i] = (tromino[i-1] + dp[i-1]) % mod;
        }
        
        return (int) dp[n];
    }
}
