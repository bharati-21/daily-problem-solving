class UnionFind {
    int n;
    int[] rank, parent;
    UnionFind(int n) {
        this.n = n;
        rank = new int[n];
        parent = new int[n];
        
        for(int i = 0; i<n; i++) {
            rank[i] = 0;
            parent[i] = i;
        }
    }
    
    private int find(int x) {
        if(parent[x] == x) return x;
        
        return parent[x] = find(parent[x]);
    }
    
    public void union(int x, int y) {
        int parX = find(x);
        int parY = find(y);
        
        if(parX != parY) {
            if(rank[parX] > rank[parY]) {
                parent[parY] = parX;
            }
            else if(rank[parY] > rank[parX]) {
                parent[parX] = parY;
            }
            else {
                parent[parY] = parX;
                rank[parX] += 1;
            }
        }
    }
    
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind uf = new UnionFind(n);
        
        for(int[] edge: edges) {
            uf.union(edge[0], edge[1]);
        }
        
        return uf.isConnected(source, destination);
    }
}
