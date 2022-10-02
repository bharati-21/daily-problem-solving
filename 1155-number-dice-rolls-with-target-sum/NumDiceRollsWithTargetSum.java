class NumDiceRollsWithTargetSum {
    private int mod = (int) (Math.pow(10,9)) + 7;
    
    public int numRollsToTarget(int n, int k, int target) {
        // No more dice to roll
        if(n == 0) {
            
            // You have n die fronts that sum up to inital target
            if(target == 0) {
                return 1;
            }
            
            // The chosen n die fronts don't sum up to initial target
            return 0;
        }
        
        int ways = 0;
        
        for(int i = 1; i<=k; i++) {
            int nextTarget = target-i;
            ways = (ways + numRollsToTarget(n-1, k, nextTarget)) % mod;
        }
        return ways % mod;
    }
}
