class Solution {
    int mod = (int) (1e9 + 7);
    public int numTilings(int n) {
        return (int) numTilingsHelper(n) % mod;
    }
    
    private long numTilingsHelper(int n) {
        if(n <= 0) return 0l;
        if(n <= 2) return n;
        
        
        // f(n-1) + f(n-2) + 2*g(n-2)
        long vert = numTilingsHelper(n-1) % mod;
        long hor = numTilingsHelper(n-2) % mod;
        long tro = numTilingsTromino(n-2) % mod;
        
        return (vert + hor + 2 * tro) % mod;
    }
    
    private long numTilingsTromino(int n) {
        if(n <= 0) return 0l;
        if(n == 1) return 1l;
                
        // g(n) = g(n-1) + f(n-1)
        long hor = numTilingsTromino(n-1) % mod;
        long tro = numTilingsHelper(n-1) % mod;
                
        return (hor + tro) % mod;
    }
}
