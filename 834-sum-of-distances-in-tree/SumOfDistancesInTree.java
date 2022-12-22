class Solution {
    private List<HashSet<Integer>> adj;
    private int[] countNodes;
    private int[] sumDist;
    
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        // generate adjacency list
        adj = new ArrayList();
        for(int i = 0; i<n; i++) {
            adj.add(new HashSet());
        }
        generateAdjList(edges, n);
        
        countNodes = new int[n];
        sumDist = new int[n];
        
        getDistFromRoot(0, -1);
        getSumOfDistances(0, -1, n);
        return sumDist;
    }
    
    private void generateAdjList(int[][] edges, int n) {
        for(int[] edge: edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }
    
    private void getDistFromRoot(int root, int parent) {
        for(int child: adj.get(root)) {
            if(child == parent) continue;
            
            getDistFromRoot(child, root);
            
            countNodes[root] += countNodes[child];
            sumDist[root] += sumDist[child] + countNodes[child];
        }
        
        countNodes[root]++;
    }
    
    private void getSumOfDistances(int root, int parent, int n) {
        for(int child: adj.get(root)) {
            if(child == parent) continue;
            
            sumDist[child] = sumDist[root] - countNodes[child] + n - countNodes[child];
            getSumOfDistances(child, root, n);
        }
    }
}

// 1 -> 0 1
// 1 -> 2 2
// 1 -> 3 3
// 1 -> 4 3
// 1 -> 5 3
