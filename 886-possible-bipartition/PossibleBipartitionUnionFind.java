class UnionFind {
    int[] parent, rank;
    int n;
    
    UnionFind(int n) {
        this.n = n;
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i = 0; i<=n; i++) {
            parent[i] = i;
        }
        
        for(int i = 0; i<=n; i++) {
            rank[i] = 1;
        }
    }
    
    public int find(int u) {
        if(parent[u] == u) return u;
        
        return parent[u] = find(parent[u]);
    } 
    
    public void union(int u, int v) {
        int parU = find(u);
        int parV = find(v);
        
        if(parU == parV) {
            return;
        }
        
        if(rank[parU] < rank[parV]) {
            parent[parU] = parV;
        }
        else if(rank[parV] < rank[parU]) {
            parent[parV] = parU;
        }
        else {
            parent[parV] = parU;
            rank[parU]++;
        }
    }
}

class Solution {
    private List<List<Integer>> adj;
    private int[] colors;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        adj = new ArrayList();
        for(int i = 0; i<=n; i++) {
            adj.add(new ArrayList());
        }
        generateAdjList(dislikes);

        UnionFind uf = new UnionFind(n);
        for(int node = 1; node<=n; node++) {
            for(int neighbor: adj.get(node)) {
                if(uf.find(node) == uf.find(neighbor)) {
                    return false;
                }
                
                uf.union(adj.get(node).get(0), neighbor);
            }
        }
        
        System.out.println(Arrays.toString(uf.parent));
        return true;
    }
    
    private void generateAdjList(int[][] dislikes) {
        for(int[] dislike: dislikes) {
            int u = dislike[0], v = dislike[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }
}
