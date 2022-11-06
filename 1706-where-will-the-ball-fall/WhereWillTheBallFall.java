class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[] answer = new int[n];
        for(int i = 0; i<n; i++) {
            int row = 0;
            int col = i;
            boolean willBallReach = true; 
            while(row < m) {
                int curr = grid[row][col];
                int adjCol = col + curr;
                if(adjCol < 0 || adjCol >= n) {
                    answer[i] = -1;
                    willBallReach = false;
                    break;
                }
                
                int adjacent = grid[row][adjCol];
                if(curr != adjacent) {
                    answer[i] = -1;
                    willBallReach = false;
                    break;
                }
                
                row++;
                col = adjCol;
            }
            if(willBallReach) answer[i] = col;
        }
        return answer;
    }
}
