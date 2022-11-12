class MedianFinder {
    PriorityQueue<Integer> pqOne, pqTwo;
    
    public MedianFinder() {
        pqOne = new PriorityQueue<>((a,b) -> b - a);
        pqTwo = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        pqOne.add(num);
        
                
        if(!pqOne.isEmpty() && !pqTwo.isEmpty() && 
           pqOne.peek() > pqTwo.peek()
          ) {
            pqTwo.add(pqOne.poll());
        }
        
       
        if(pqOne.size() > pqTwo.size() + 1) {
            pqTwo.add(pqOne.poll());
        }
        if(pqTwo.size() > pqOne.size() + 1) {
            pqOne.add(pqTwo.poll());
        }
    }
    
    public double findMedian() {
        int s1 = pqOne.size();
        int s2 = pqTwo.size();
        
        if(s1 > s2) {
            return (double) pqOne.peek();
        }
        else if(s2 > s1) {
            return (double) pqTwo.peek();
        }
        double first = pqOne.peek();
        double second = pqTwo.peek();
            
        return (first + second) / 2.0;
    }
}
