class NumDiceRollsWithTargetSumMemoized {
    private int mod = (int) (Math.pow(10,9) + 7);

    public int numRollsToTarget(int n, int k, int target) {
        int[][] memoized = new int[n+1][target+1];
        for(int[] row: memoized) {
            Arrays.fill(row, -1);
        }
        
        return numRollsToTargetHelper(n, k, target, memoized);
    }
    
    private int numRollsToTargetHelper(int n, int k, int target, int[][] memoized) {
        // No more dice to roll or if the target is < 0
        // Adding this condition here because we don't want to go out of bounds.
        if(n == 0 || target < 0) {
            return (target == 0) ? 1 : 0;
        }
        
        // If the subproblem was already computed, return memoized result
        if(memoized[n][target] != -1) {
            return memoized[n][target] ;
        }
        
        int ways = 0;
        for(int i = 1; i<=k; i++) {
            int nextTarget = target-i;
            ways = (ways + numRollsToTargetHelper(n-1, k, nextTarget, memoized)) % mod;
        }
        // memoize result and return
        memoized[n][target] = ways;
        return ways;
    }
}
