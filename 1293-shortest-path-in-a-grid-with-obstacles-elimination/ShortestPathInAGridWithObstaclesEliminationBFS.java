class Block {
    int row, col, k, step;
    Block(int row, int col, int k, int step) {
        this.row = row;
        this.col = col;
        this.k = k;
        this.step = step;
    }
}

class Solution {
    public int shortestPath(int[][] grid, int k) {
        Queue<Block> queue = new LinkedList();
        int[][] directions = new int[][] {
            {-1,0}, {1,0}, {0,-1}, {0,1}
        };
        
        int m = grid.length, n = grid[0].length;
        
        boolean[][][] visited = new boolean[m][n][k+1];
        Block t = new Block(0, 0, k, 0);
        queue.add(t);
        visited[0][0][k] = true;
                
        while(!queue.isEmpty()) {
            Block front = queue.poll();
            int row = front.row;
            int col = front.col;
            int removals = front.k;
            int step = front.step;
                        
            if(row == m-1 && col == n-1) {
                return step;
            }
            
            int curr = grid[row][col];
            if(curr == 1) {
                if(removals == 0) {
                    // you can no longer move down this path
                    continue;
                }
                else {
                    removals -= 1;
                }
            }
            
            for(int[] dir: directions) {
                int nRow = row + dir[0];
                int nCol = col + dir[1];
                int newStep = step + 1;
                if(nRow < 0 || nCol < 0 || nRow >= m || nCol >= n || visited[nRow][nCol][removals]) {
                    continue;
                }
                
                Block child = new Block(nRow, nCol, removals, newStep);
                visited[nRow][nCol][removals] = true;
                queue.add(child);
            }
        }
        
        return -1;
    }
}
