class MinTimePriorityQueue {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        
        int cost = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i<n;) {
            char color = colors.charAt(i);
            int time = neededTime[i];
                
            // Add the current time to the PQ
            pq.add(time);
            
            int j = i+1;
            // Check for consecutive balloons with same colors
            while(j < n && color == colors.charAt(j)) {
                pq.add(neededTime[j]);
                j++;
            }
            
            // Remove k-1 elements from the PQ => this removed k-1 smallest elements
            while(pq.size() > 1) {
                cost+= pq.poll();
            }
            
            // Remove the extra element
            pq.poll();
            i = j;
        }
        
        return cost;
    }
}
