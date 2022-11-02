class Pair {
    String node;
    int mutations;
    Pair(String node, int mutations) {
        this.node = node;
        this.mutations = mutations;
    }
}

class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Queue<Pair> queue = new LinkedList();
        Set<String> set = new HashSet();
        
        Pair startPair = new Pair(start, 0);
        queue.add(startPair);
        set.add(start);
        
        char[] geneChars = new char[] {'A', 'C', 'G', 'T'};
        
        while(!queue.isEmpty()) {
            Pair p = queue.poll();
            
            String s = p.node;
            int mutations = p.mutations;
            
            if(s.equals(end)) {
                return mutations;
            }
            
            for(char ch: geneChars) {
                for(int i = 0; i<s.length(); i++) {
                    String nextGene = s.substring(0,i) + ch + s.substring(i+1);
                    Pair next = new Pair(nextGene, mutations + 1);
                    
                    if(!set.contains(nextGene) && isInBank(nextGene, bank)) {
                        set.add(nextGene);
                        queue.add(next);
                    }
                }
            }
        }
        
        return -1;
    }
    
    private boolean isInBank(String s, String[] bank) {
        for(String b: bank) {
            if(s.equals(b)) return true;
        }
        
        return false;
    }
}
