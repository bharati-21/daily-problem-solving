class Solution {
    private int[][] memo;
    private int m, n;
    public int longestCommonSubsequence(String text1, String text2) {
        m = text1.length();
        n = text2.length();
        
        memo = new int[m][n];
        for(int[] row: memo) {
            Arrays.fill(row, -1);
        }
        
        return lcsHelper(text1, m-1, text2, n-1);
    }
    
    private int lcsHelper(String text1, int i, String text2, int j) {
        if(i < 0 || j < 0) return 0;
        
        if(memo[i][j] != -1) return memo[i][j];
        
        char text1Ch = text1.charAt(i);
        char text2Ch = text2.charAt(j);
        
        if(text1Ch == text2Ch) {
            return memo[i][j] = 1 + lcsHelper(text1, i-1, text2, j-1);
        }
        
        int decrementI = lcsHelper(text1, i-1, text2, j);
        int decrementJ = lcsHelper(text1, i, text2, j-1);
        
        return memo[i][j] = Math.max(decrementI, decrementJ);
    }
}
