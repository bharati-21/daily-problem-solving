class Solution {
    public int numSquares(int n) {
        if(n <= 0) return -1;
        
        Queue<Integer> queue = new LinkedList();
        Set<Integer> set = new HashSet();
        queue.add(n);
        set.add(n);
        
        int numbers = 0;
        
        while(!queue.isEmpty()) {
            numbers++;
            int size = queue.size();
            
            while(size-- > 0) {
                int num = queue.poll();

                for(int i = 1; i <= Math.sqrt(num); i++) {
                    int nextNum = num - (i*i);
                    if(nextNum == 0) return numbers;
                    if(!set.contains(nextNum)) {
                        set.add(nextNum);
                        queue.add(nextNum);
                    }
                }
            }
        }
        
        return numbers;
    }
}
