class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(d > n) {
            return -1;
        }

        int[][] memo = new int[n+1][d+1];
        for(int[] row: memo) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        return minDifficultyHelper(jobDifficulty, d, 0, n, memo);
    }

    // 
    private int minDifficultyHelper(int[] jobDifficulty, int d, int start, int n, int[][] memo) {
        if(d == 1) {
            // return the max at this value from start to n
            return getMax(jobDifficulty, start, n-1);
        }

        if(memo[start][d] != Integer.MAX_VALUE) {
            return memo[start][d];
        }

        int minValue = memo[start][d];
        for(int i = start; i<=n-d; i++) {
            // This gets the values at the cut [i+1, n)
            int nextCut = minDifficultyHelper(jobDifficulty, d-1, i+1, n, memo);
            int currentCutMax = getMax(jobDifficulty, start, i);

            minValue = Math.min(minValue, (nextCut + currentCutMax));
            memo[start][d] = minValue;
        }

        return memo[start][d] = minValue;
    }

    private int getMax(int[] jobDifficulty, int i, int j) {
        int currentCutMax = 0;
        while(i <= j) {
            currentCutMax = Math.max(jobDifficulty[i], currentCutMax);
            i++;
        }

        return currentCutMax;
    }
}
