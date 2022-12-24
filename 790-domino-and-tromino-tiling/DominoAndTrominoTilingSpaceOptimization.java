class Solution {
    int mod = (int) (1e9 + 7);
    public int numTilings(int n) {
        if(n == 0) return 0;
        if(n <= 2) return n;
        
        long firstTiling = 1;
        long secondTiling = 2;
        
        long firstTromino = 1;
        long secondTromino = 2;
        
        for(int i = 3; i<=n; i++) {
            long currentTiling = (firstTiling + secondTiling + 
                                  2 * firstTromino) % mod;
            long currentTromino = (secondTromino + secondTiling) % mod;
            
            firstTiling = secondTiling;
            secondTiling = currentTiling;
            
            firstTromino = secondTromino;
            secondTromino = currentTromino;
        }
        
        return (int) secondTiling;
    }
}
