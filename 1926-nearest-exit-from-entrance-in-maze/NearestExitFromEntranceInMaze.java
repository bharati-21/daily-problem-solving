class Cell {
    int row, col;
    Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        if(maze == null || maze.length == 0) return -1;
        
        int m = maze.length, n = maze[0].length;
        char[][] mazeCopy = new char[m][n];
        for(int i = 0; i<m; i++) {
            mazeCopy[i] = maze[i].clone();
        }
        
        Queue<List<Integer>> paths = new LinkedList<>();        
        int startRow = entrance[0], startCol = entrance[1];
        int[][] directions = new int[][] {
            {-1,0}, {1,0}, {0,-1}, {0,1}
        };
        
        List<Integer> startCell = new ArrayList();
        startCell.add(startRow);
        startCell.add(startCol);
        startCell.add(0);
        
        paths.add(startCell);
        mazeCopy[startRow][startCol] = '+';
        int smallestPath = 0;
        while(!paths.isEmpty()) {
            List<Integer> currCell = paths.poll();
            int currRow = currCell.get(0), currCol = currCell.get(1);
            int currStep = currCell.get(2);
                        
            for(int[] dir: directions) {
                int nextRow = currRow + dir[0];
                int nextCol = currCol + dir[1];
                int nextStep = currStep + 1;
                
                List<Integer> nextCell  = new ArrayList<>();
                nextCell.add(nextRow);
                nextCell.add(nextCol);
                nextCell.add(nextStep);
                                
                if(isInvalidCell(nextCell, nextRow, nextCol, mazeCopy)) {
                    continue;
                }
                
                if(nextRow == 0 || nextRow == m-1 || nextCol == 0 || nextCol == n-1) {
                    return nextStep;
                }
                 
                paths.add(nextCell);
                mazeCopy[nextRow][nextCol] = '+';
            }
        }
        
        return -1;
    }
    
    private boolean isInvalidCell(List<Integer> cell, int row, int col, char[][] maze) {
        int m = maze.length, n = maze[0].length;
        if(row < 0 || col < 0 || row >= m || col >= n || maze[row][col] == '+') {
            return true;
        }
        
        return false;
    }
}
