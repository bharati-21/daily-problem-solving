class Solution {
    private int mod = (int) 1e9 + 7; 
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        
        int sum = 0;
        Stack<Pair<Integer, Integer>> stack = new Stack();
        
        for(int rightIndex = 0; rightIndex<=n; rightIndex++) {
            while(!stack.isEmpty() && 
                  (rightIndex == n || 
                   stack.peek().getValue() >= arr[rightIndex])
            ) {
                Pair<Integer, Integer> mid = stack.pop();
                int midIndex = mid.getKey();
                int midVal = mid.getValue();
                
                int leftIndex = -1;
                if(!stack.isEmpty()) {
                    Pair<Integer, Integer> left = stack.peek();
                    leftIndex = left.getKey();
                }
                long numArrays = ((rightIndex - midIndex) * (midIndex - leftIndex)) % mod;
                long numSum = numSubsets * midVal;
                
                sum = (int) ((sum + numSum) % mod);
                
            }
            int num = (rightIndex == n) ? -1 : arr[rightIndex];
            stack.push(new Pair(rightIndex, num));
        }
        
        return sum;
    }
}
