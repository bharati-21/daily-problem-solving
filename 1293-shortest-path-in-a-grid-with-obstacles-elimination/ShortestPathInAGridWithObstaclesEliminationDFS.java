class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        
        boolean[][][] visited = new boolean[m][n][k+1];
        int[][][] memo = new int[m][n][k+1];
        for(int[][] row1: memo) {
            for(int[] row2: row1) {
                Arrays.fill(row2, -1);
            }
        }
        int ans = shortestPathHelper(m-1, n-1, grid, k, visited, memo);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    private int shortestPathHelper(int i, int j, int[][] grid, int k, boolean[][][] visited, int[][][] memo) {
        int m = grid.length, n = grid[0].length;
        if(i == 0 && j == 0) {
            return 0;
        }
        if(visited[i][j][k]) {
            return Integer.MAX_VALUE;
        }
        
        if(memo[i][j][k] != -1) {
            return memo[i][j][k];
        }
        
        // if(k >= i + j) return memo[i][j][k] = i+j;
        
        visited[i][j][k] = true;
        int left = Integer.MAX_VALUE, 
            right = Integer.MAX_VALUE, 
            down = Integer.MAX_VALUE, 
            top = Integer.MAX_VALUE;
        
        int curr = grid[i][j];
        if(curr == 1 && k == 0) {
            return memo[i][j][k] = Integer.MAX_VALUE;
        }
        
        int l = j-1;
        int r = j+1;
        int t = i-1;
        int d = i+1;
        
        // I can move in either of the 4 directions
        // Need to check the boundaries for them
        // Another catch is what if I have an obstacle
        // To eliminate or not eliminate is another option
        // If I have an obstacle than I have 2*4 = 8 choices
        // else I have 4 choices
        
        if(l >= 0) {
            if(curr == 0)
                left = shortestPathHelper(i, l, grid, k, visited, memo);
            if(curr == 1) {
                // remove this obstacle and also check
                left = Math.min(left, shortestPathHelper(i, l, grid, k-1, visited, memo));
            }
        }
        if(r < n) {
            if(curr == 0)
                right = shortestPathHelper(i, r, grid, k, visited, memo);
            if(curr == 1 ) {
                // remove this obstacle and also check
                right = Math.min(right, shortestPathHelper(i, r, grid, k-1, visited, memo));
            }
        }
        if(t >= 0) {
            if(curr == 0)
                top = shortestPathHelper(t, j, grid, k, visited, memo);
            if(curr == 1) {
                // remove this obstacle and also check
                top = Math.min(top, shortestPathHelper(t, j, grid, k-1, visited, memo));
            }
        }
        if(d < m) {
            if(curr == 0)
                down = shortestPathHelper(d, j, grid, k, visited, memo);
            if(curr == 1) {
                // remove this obstacle and also check
                down = Math.min(down, shortestPathHelper(d, j, grid, k-1, visited, memo));
            }
        }
            
        int iMin = Math.min(top, down);
        int jMin = Math.min(right, left);
        int min = Math.min(iMin, jMin);
        if(min != Integer.MAX_VALUE) {
            min += 1;
        }
            
        visited[i][j][k] = false;
        return memo[i][j][k] = min;
    } 
}
