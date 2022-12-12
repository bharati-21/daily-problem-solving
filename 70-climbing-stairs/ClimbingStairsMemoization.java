class Solution {
    private int[] memo;
    public int climbStairs(int n) {
        memo = new int[n+1];
        if(n <= 2) return n;
        
        return climbStairsHelper(n);
    }
    
    private int climbStairsHelper(int n) {
        if(n < 0) return 0;
        if(n <= 2) return n;
        
        if(memo[n] != 0) return memo[n];
        
        return memo[n] = climbStairsHelper(n-1) + 
            climbStairsHelper(n-2);
    }
}
