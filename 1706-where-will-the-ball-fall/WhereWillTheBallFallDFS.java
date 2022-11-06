class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[] answer = new int[n];
        for(int i = 0; i<n; i++) {
            int ans = dfs(0, i, grid);
            answer[i] = ans;
        }
        return answer;
    }
    
    // 0,0 == 0,1
    // 1,1 == 1,2
    // 2,2 == 2,1
    // 3,1 == 3,2
    // 4,2 == 4,1
    private int dfs(int row, int col, int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if(row == m) return col;
        
        int cell = grid[row][col];
        
        int ans = -1;
        
        if(cell == 1) {
            // move in right dir
            if(col == n-1) {
                // Then this is blocked because there's no right cell
                return -1;
            }
            int nextCell = grid[row][col+1];
            if(nextCell != cell) {
                return -1;
            }
            return dfs(row+1, col+1, grid);
        }
        if(col == 0) {
            // Then this is blocked becuase there's no left cell
            return -1;
        }
        int prevCell = grid[row][col-1];
        if(prevCell != cell) {
            return -1;
        }
        return dfs(row+1, col-1, grid);
    }
}

/*
[
[1,1,1,1,1,1],
[-1,-1,-1,-1,-1,-1],
[1,1,1,1,1,1],
[-1,-1,-1,-1,-1,-1]
]
*/
