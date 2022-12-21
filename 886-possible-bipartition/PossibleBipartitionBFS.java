class Solution {
    private List<List<Integer>> adj;
    private int[] colors;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        adj = new ArrayList();
        for(int i = 0; i<=n; i++) {
            adj.add(new ArrayList());
        }
        generateAdjList(dislikes);
        colors = new int[n+1];
        
        for(int i = 1; i<=n; i++) {
            if(colors[i] == 0) {
                boolean isBipartite = traverseNodes(n, i);
                if(!isBipartite) return false;
            }
        }
        
        return true;
    }
    
    private void generateAdjList(int[][] dislikes) {
        for(int[] dislike: dislikes) {
            int u = dislike[0], v = dislike[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }
    
    private boolean traverseNodes(int n, int source) {
        Queue<Integer> nodes = new LinkedList();
        
        colors[source] = 1;
        nodes.add(source);
        
        while(!nodes.isEmpty()) {
            int currNode = nodes.poll();
            int currColor = colors[currNode];
            
            for(int nextNode: adj.get(currNode)) {
                if(colors[nextNode] == 0) {
                    colors[nextNode] = (currColor == 1) ? 2 : 1;
                    nodes.add(nextNode);
                } 
                else if(colors[nextNode] == currColor) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
