class Solution {
    private List<List<Integer>> adj;
    private Set<Integer> visited;
    
    public boolean validPath(int n, int[][] edges, 
    int source, int destination) {
        adj = new ArrayList();
        for(int i = 0; i<n; i++) {
            adj.add(new ArrayList());
        }
        generateAdjList(edges);
        visited = new HashSet();
        return bfs(source, destination);
    }
    
    private void generateAdjList(int[][] edges) {
        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }
    
    private boolean bfs(int source, int destination) {
        Queue<Integer> nodes = new LinkedList();
        nodes.add(source);
        visited.add(source);

        while(!nodes.isEmpty()) {
            int currNode = nodes.poll();

            if(currNode == destination) {
                return true;
            }

            for(int nextNode: adj.get(currNode)) {
                if(!visited.contains(nextNode)) {
                    visited.add(nextNode);
                    nodes.add(nextNode);
                }
            }
        }

        return false;
    }
}
