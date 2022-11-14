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
        
        for(int i = 0; i<n; i++) {
            int[] s1 = stones[i];
            for(int j = i+1; j<n; j++) {
                int[] s2 = stones[j];
                if(s1[0] == s2[0] || s1[1] == s2[1]) {
                    uf.union(i,j);
                }
            }
        }
        
        return n - uf.getNumConnectedComponents();
    }
}
