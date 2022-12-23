class Solution {
    private int[][] memo;
    private int n;
    
    public int maxProfit(int[] prices) {
        n = prices.length;
        memo = new int[n][2];
        for(int[] row: memo) Arrays.fill(row, -1);
        
        return maxProfitHelper(prices, 0, 1);
    }
    
    private int maxProfitHelper(int[] prices, int index, 
                                int canBuy) {
        if(index >= n) return 0;
        
        if(memo[index][canBuy] != -1) return memo[index][canBuy];
        
        int price = prices[index];
        int profit = 0;
        
        if(canBuy == 1) {
            int buyNow = -price + 
                maxProfitHelper(prices, index+1, 0);
            int buyNext = 0 + 
                maxProfitHelper(prices, index+1, 1);
            
            profit = Math.max(buyNow, buyNext);
        }
        else {
            int sellNow = price + 
                maxProfitHelper(prices, index+2, 1);
            int sellNext = 0 +
                maxProfitHelper(prices, index+1, 0);
            
            profit = Math.max(sellNow, sellNext);
        }
        
        return memo[index][canBuy] = profit;
    }
}
