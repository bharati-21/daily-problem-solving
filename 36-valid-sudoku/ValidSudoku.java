class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<String, HashSet<Character>> map = new HashMap();
        
        for(int row = 0; row<9; row++) {
            for(int col = 0; col<9; col++) {
                char ch = board[row][col];
                if(ch == '.') continue;
                
                String grid = "grid" + (row/3) + (col/3);
                String rowKey = "row" + row;
                String colKey = "col" + col;
                
                if(!map.containsKey(rowKey)) {
                    map.put(rowKey, new HashSet());
                }
                if(!map.get(rowKey).add(ch)) return false;
                
                if(!map.containsKey(colKey)) {
                    map.put(colKey, new HashSet());
                }
                if(!map.get(colKey).add(ch)) return false;
                
                if(!map.containsKey(grid)) {
                    map.put(grid, new HashSet());
                }
                if(!map.get(grid).add(ch)) return false;
            }
        }
                
        return true;
    }
}
