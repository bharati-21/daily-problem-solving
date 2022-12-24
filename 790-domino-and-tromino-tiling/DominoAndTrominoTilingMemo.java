class Solution {
    int mod = (int) (1e9 + 7);
    long[] memo, tromino;
    public int numTilings(int n) {
        memo = new long[n+1];
        tromino = new long[n+1];
        
        Arrays.fill(memo, -1);
        Arrays.fill(tromino, -1);
        
        return (int) numTilingsHelper(n) % mod;
    }
    
    private long numTilingsHelper(int n) {
        if(n <= 0) return 0l;
        if(n <= 2) return n;
        
        if(memo[n] != -1) return memo[n] % mod;
        
        // f(n-1) + f(n-2) + 2*g(n-2)
        long verticalTile = numTilingsHelper(n-1) % mod;
        long horizontalTile = numTilingsHelper(n-2) % mod;
        long trominoTile = numTilingsTromino(n-2) % mod;
        
        return memo[n] = (verticalTile + horizontalTile + 
                          2 * trominoTile) % mod;
    }
    
    private long numTilingsTromino(int n) {
        if(n <= 0) return 0l;
        if(n == 1) return 1l;
        
        if(tromino[n] != -1) return tromino[n];
        
        // g(n) = g(n-1) + f(n-1)
        long horizontalTile = numTilingsTromino(n-1) % mod;
        long trominoTile = numTilingsHelper(n-1) % mod;
                
        return tromino[n] = (horizontalTile + trominoTile) % mod;
    }
}
