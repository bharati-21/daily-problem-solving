class Solution {
    public int removeStones(int[][] stones) {
        if(stones == null || stones.length == 0) return 0;
        
        int n = stones.length;
        Set<int[]> visited = new HashSet();
        int islands = 0;
        
        for(int i = 0; i<n; i++) {
            int[] stone = stones[i];
            if(!visited.contains(stone)) {
                islands++;
                dfs(i, stones, visited);
            }
        }
        
        return n - islands;
    }
    
    private void dfs(int row, int[][] stones, Set<int[]> visited) {
        int[] stone = stones[row];
        int n = stones.length;
        
        visited.add(stone);
        
        for(int i = 0; i<n; i++) {
            int[] s = stones[i];
            if(!visited.contains(s)) {
                if(stone[0] == s[0] || stone[1] == s[1]) {
                    dfs(i, stones, visited);
                }
            }
        }
    }
}
