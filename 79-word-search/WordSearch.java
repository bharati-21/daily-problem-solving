class Solution {
    private int m, n;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) return false;
        
        m = board.length;
        n = board[0].length;
        
        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                char firstCh = word.charAt(0);
                if(board[row][col] == firstCh) {
                    if(search(board, word, row, col, 0)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    private boolean search(char[][] board, String word, int row, int col, int index) {
        int len = word.length();
        if(index >= len) {
            return true;
        }
        
        if(row < 0 || row >= m || col < 0 || col >= n || board[row][col] == '.') {
            return false;
        }
        
        char ch = board[row][col];
        char wordCh = word.charAt(index);
        
        if(ch != wordCh)  return false;
        
        board[row][col] = '.';
        
        boolean ans = search(board, word, row-1, col, index+1) || 
            search(board, word, row+1, col, index+1) || 
            search(board, word, row, col-1, index+1) ||
            search(board, word, row, col+1, index+1);
        
        board[row][col] = ch;
        return ans;
    }
}
