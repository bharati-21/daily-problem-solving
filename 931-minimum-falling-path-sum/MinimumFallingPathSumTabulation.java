class Solution {    
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        
        // the first row 
        for(int col = 0; col < cols; col++) {
            dp[0][col] = matrix[0][col];
        }
        
        for(int i = 1; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for(int row = 1; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                int curr = matrix[row][col];
                
                int diagLeft = Integer.MAX_VALUE;
                if((col - 1) >= 0) {
                    diagLeft = dp[row-1][col-1];
                }
                int diagRight = Integer.MAX_VALUE;
                if((col + 1) < cols) {
                    diagRight = dp[row-1][col+1];
                }
                int up = dp[row-1][col];
                
                int min = Math.min(diagLeft, diagRight);
                min = Math.min(min, up) + curr;
                dp[row][col] = Math.min(dp[row][col], min);
            }
        }
        
        int min = dp[rows-1][0];
        for(int i = 0; i<cols; i++) {
            min = Math.min(min, dp[rows-1][i]);
        }
        return min;
    }
}
