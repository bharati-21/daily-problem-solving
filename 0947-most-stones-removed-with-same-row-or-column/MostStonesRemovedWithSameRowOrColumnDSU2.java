class UnionFind {
    int[] parent, rank;
    int n;
    int connectedComponents;
    
    UnionFind(int n) {
        this.n = n;
        parent = new int[n];
        rank = new int[n];
        connectedComponents = n;
        
        for(int i = 0; i<n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    
    private int find(int x) {
        if(x == parent[x]) return x;
        
        return parent[x] = find(parent[x]);
    }
    
    public void union(int x, int y) {
        int parX = find(x);
        int parY = find(y);
        
        if(parX == parY) {
            return;
        }
        
        if(rank[parX] < rank[parY]) {
            parent[parX] = parent[parY];
            rank[parY]++;
        }
        else {
            parent[parY] = parent[parX];
            rank[parX]++;
        }
        
        connectedComponents--;
    }
    
    public int getNumConnectedComponents() {
        return connectedComponents;
    }
}

class Solution {
    public int removeStones(int[][] stones) {
        if(stones == null || stones.length == 0) return 0;
        
        int n = stones.length;
        UnionFind uf = new UnionFind(n);
        
        Map<Integer, List<Integer>> rows = new HashMap(), cols = new HashMap();
        
        for(int i = 0; i<n; i++) {
            int[] stone = stones[i];
            int row = stone[0], col = stone[1];
            
            if(!rows.containsKey(col)) {
                rows.put(col, new ArrayList());
            }
            rows.get(col).add(i);
            
            if(!cols.containsKey(row)) {
                cols.put(row, new ArrayList());
            }
            cols.get(row).add(i);
        }
        
        for(int col: rows.keySet()) {
            List<Integer> list = rows.get(col);
            int parentIndex = list.get(0);
            
            for(int i = 1; i<list.size(); i++) {
                int childIndex = list.get(i);
                uf.union(parentIndex, childIndex);
            }
        }
        
        for(int row: cols.keySet()) {
            List<Integer> list = cols.get(row);
            int parentIndex = list.get(0);
            
            for(int i = 1; i<list.size(); i++) {
                int childIndex = list.get(i);
                uf.union(parentIndex, childIndex);
            }
        }
        return n - uf.getNumConnectedComponents();
    }
}
