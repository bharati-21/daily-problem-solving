class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(d > n) {
            return -1;
        }

        return minDifficultyHelper(jobDifficulty, d, 0, n);
    }

    // 
    private int minDifficultyHelper(int[] jobDifficulty, int d, int start, int n) {
        if(d == 1) {
            // return the max at this value from start to n
            return getMax(jobDifficulty, start, n-1);
        }

        int minValue = Integer.MAX_VALUE;
        for(int i = start; i<=n-d; i++) {
            // This gets the values at the cut [i+1, n)
            int nextCut = minDifficultyHelper(jobDifficulty, d-1, i+1, n);
            int currentCutMax = getMax(jobDifficulty, start, i);

            minValue = Math.min(minValue, (nextCut + currentCutMax));
        }

        return minValue;
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
