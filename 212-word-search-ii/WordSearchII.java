class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEnd;
    String word;
    TrieNode() {
        children = new HashMap();
    }
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        
        TrieNode root = addWordsToTrie(words);
        List<String> output = new ArrayList();
         
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(!root.children.containsKey(board[i][j])) {
                    continue;
                }
                
                searchBoard(board, i, j, root, visited, output);
            }
        }
        
        return output;
    }
    
    public TrieNode addWordsToTrie(String[] words) {
        TrieNode root = new TrieNode();
        
        for(String word: words) {
            TrieNode curr = root;
            
            for(int i = 0; i<word.length(); i++) {
                char ch = word.charAt(i);

                if(!curr.children.containsKey(ch)) {
                    curr.children.put(ch, new TrieNode());
                }

                curr = curr.children.get(ch);
            }
            curr.word = word;
            curr.isEnd = true;
        }
        
        return root;
    }

    private void searchBoard(char[][] board, int row, int col, TrieNode root, boolean[][] visited, List<String> output) {
        int m = board.length, n = board[0].length;
        
        if(root.isEnd) {
            output.add(new String(root.word));
            root.isEnd = false;
            root.word = null;
        }
        
        if(row >= m || row < 0 || col >= n || col < 0 || visited[row][col]) {
            return;
        }
        
        char currChar = board[row][col];
        if(!root.children.containsKey(currChar)) {
            return;
        }
        
        visited[row][col] = true;
        
        int[][] directions = new int[][] {
            {-1, 0}, {1,0}, {0,-1}, {0,1}
        };
        
        root = root.children.get(currChar);
        
        for(int[] dir: directions) {
            int nRow = dir[0] + row;
            int nCol = dir[1] + col;
            searchBoard(board, nRow, nCol, root, visited, output);
        }
        
        visited[row][col] = false;
    }
}
