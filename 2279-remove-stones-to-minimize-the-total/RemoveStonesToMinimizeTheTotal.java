class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
            (a,b) -> b-a
        );
        
        for(int pile: piles) {
            pq.add(pile);
        }
        
        while(k-- > 0) {
            int pile = pq.remove();
            int half = pile / 2; 
            pile -= half;
            pq.add(pile);
        }
        
        int total = 0;
        while(!pq.isEmpty()) {
            total += pq.poll();
        }
        
        return total;
    }
}
