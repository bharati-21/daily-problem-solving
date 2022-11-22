class Solution {
    public int numSquares(int n) {
        if(n <= 0) return 0;
        
        int[] memoized = new int[n+1];
        Arrays.fill(memoized, -1);
        return numberOfPerferSquares(n, memoized);
    }
    
    private int numberOfPerferSquares(int n, int[] memoized) {
        if(n < 0) return Integer.MAX_VALUE;
        if(n == 0) return 0;
        
        if(memoized[n] != -1) return memoized[n];
        
        int answer = Integer.MAX_VALUE;
        for(int i = 1; i <= Math.sqrt(n); i++) {
            int nextNum = n - (i*i);
            int nextAnswer = numberOfPerferSquares(nextNum, memoized);
            answer = Math.min(answer, nextAnswer);
            
        }
        
        return memoized[n] = answer + 1;
    }
}
