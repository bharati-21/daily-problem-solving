class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for(int index = n-1; index >= 0; index--) {
            for(int canBuy = 0; canBuy < 2; canBuy++) {
                int price = prices[index];
                int profit = 0;
                
                int next = index+1;
                if(canBuy == 1) {
                    int buyNow = -price + 
                        (next >= n ? 0 : dp[next][0]);
                    int buyNext = (next >= n) ? 0 : dp[next][1];
                    
                    profit = Math.max(buyNow, buyNext);    
                }
                else {
                    int sellNowNext = index+2;
                    
                    int sellNow = price + 
                        (sellNowNext >= n ? 0 : dp[sellNowNext][1]);
                    int sellNext = (next >= n) ? 0 : dp[next][0];
                    
                    profit = Math.max(sellNow, sellNext); 
                }
                
                dp[index][canBuy] = profit;
            }
        }
        
        return dp[0][1];
    }
}
