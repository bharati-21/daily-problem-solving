class Solution {
    int mod = (int) (1e9 + 7);
    public int numTilings(int n) {
        if(n == 0) return 0;
        if(n <= 2) return n;
        
        long firstTiling = 1; // f(1) 
        long secondTiling = 2; // f(2)
        long thirdTiling = 5; // f(3)
        
        
        for(int i = 4; i<=n; i++) {
            // 2 * n-1 + n-3
            long currentTiling = ((2 * thirdTiling) + firstTiling) % mod;
            firstTiling = secondTiling;
            secondTiling = thirdTiling;
            thirdTiling = currentTiling;
        }
        
        return (int) thirdTiling;
    }
}
