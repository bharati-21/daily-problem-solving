class Solution {
    private int[][] memo;
    private int rows, cols;
    
    public int minFallingPathSum(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        memo = new int[rows][cols];
        
        for(int[] row: memo) {
            Arrays.fill(row, Integer.MAX_VALUE);    
        }
        
        int min = Integer.MAX_VALUE;
        for(int col = 0; col < cols; col++) {
            min = Math.min(min, 
                  minPathSumHelper(rows-1, col, matrix));
        }
        
        return min;
    }
    
    private int minPathSumHelper(int row, int col, int[][] grid) {
        if(col >= cols || col < 0) {
            return Integer.MAX_VALUE;
        }
        if(row == 0) {
            return grid[row][col];
        }
        
        if(memo[row][col] != Integer.MAX_VALUE) {
            return memo[row][col];
        }
        
        int curr = grid[row][col];
        
        int diagLeft = minPathSumHelper(row-1, col-1, grid);
        int diagRight = minPathSumHelper(row-1, col+1, grid);
        int down = minPathSumHelper(row-1, col, grid);
        
        int min = Math.min(diagLeft, diagRight);
        return memo[row][col] = curr + Math.min(min, down);
    }
}
