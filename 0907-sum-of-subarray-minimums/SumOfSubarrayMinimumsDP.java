class Solution {
    private int mod = (int) 1e9 + 7; 
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        // sum of mins of all subarrays ending at index i
        int[] dp = new int[n];
        Stack<Integer> stack = new Stack();
                
        for(int i = 0; i<n; i++) {
            int num = arr[i];
            
            while(!stack.isEmpty() && arr[stack.peek()] >= num) {
                stack.pop();
            }
            
            if(stack.isEmpty()) {
                dp[i] = (i+1) * num;
            }
            else {
                int prevSmaller = stack.peek();
                dp[i] = dp[prevSmaller] + (i - prevSmaller) * num;
            }
            stack.push(i);
        }
        
        int sum = 0;
        for(int s: dp) {
            sum = (s + sum) % mod;
        }
        
        return sum;
    }
}

/*
- find all the subarrays O(N^2) and min of every subarray => O(N^3)
*/
