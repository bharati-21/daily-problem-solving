class NodePath {
    // holds current node
    // path used to visit the current node
    int node;
    List<Integer> path;
    NodePath(int node, List<Integer> path) {
        this.node = node;
        this.path = path;
    } 
}

class Solution {
    private int n;
    private List<List<Integer>> paths;
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length;
        paths = new ArrayList();
        
        Queue<NodePath> nodesToProcess = new LinkedList();
        NodePath initial = new NodePath(0, new ArrayList());
        nodesToProcess.add(initial);
        
        while(!nodesToProcess.isEmpty()) {
            NodePath currNodePath = nodesToProcess.poll();
            int currNode = currNodePath.node;
            List<Integer> currPath = currNodePath.path;
            
            currPath.add(currNode);
            
            if(currNode == n-1) {
                paths.add(new ArrayList(currPath));
            }
            else {
                for(int nextNode: graph[currNode]) {
                    NodePath nextNodePath = new 
                        NodePath(nextNode, new ArrayList(currPath));

                    nodesToProcess.add(nextNodePath);
                }
            }
        }
        
        return paths;
    }
}
