class Solution {
    private List<List<Integer>> adj;
    private Set<Integer> visited;
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        adj = new ArrayList();
        for(int i = 0; i<n; i++) {
            adj.add(new ArrayList());
        }
        generateAdjList(edges);
        visited = new HashSet();
        return dfs(source, destination);
    }
    
    private void generateAdjList(int[][] edges) {
        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }
    
    private boolean dfs(int source, int destination) {
        visited.add(source);
        if(source == destination) return true;
                
        for(int node: adj.get(source)) {
            if(!visited.contains(node)) {
                if(dfs(node, destination)) return true;
            }
        }
        
        return false;
    }
}
