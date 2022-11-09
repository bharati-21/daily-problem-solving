class StockSpanner {
    Stack<Pair<Integer, Integer>> max;
    
    public StockSpanner() {
        max = new Stack<>();
    }
    
    public int next(int price) {
        int count =  1;
        
        while(!max.isEmpty() && max.peek().getKey() <= price) {
            count += max.pop().getValue();
        }
        
        max.add(new Pair(price, count));
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
