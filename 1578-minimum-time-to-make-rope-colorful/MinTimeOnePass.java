class Solution {
    public int minCost(String colors, int[] neededTime) {
        if(colors == null || colors.length() == 0 || neededTime == null || neededTime.length == 0) {
            return 0;
        }
        
        int n = colors.length();
        int cost = 0;
                
        int prevColor = colors.charAt(0);
        int prevTime = neededTime[0];
        int maxVal = prevTime;
        int sum = prevTime;
        
        for(int i = 1; i<n; i++) {
            int currColor = colors.charAt(i);
            
            // If the current color is not equal to the previous color, then
            // update the cost, sum, and maxVal
            if(currColor != prevColor) {
                cost += (sum-maxVal);
                
                maxVal = 0;
                sum = 0;
            }
            
            int currTime = neededTime[i];
            maxVal = Math.max(currTime, maxVal);
            sum+=currTime;
            prevColor = currColor;
        }
        
        // This is required because if the last few colors are same, then 
        // the min values among the sum of times needs to be added to the final cost
        // If not (sum-maxVal) would anyway lead to 0
        return cost + (sum-maxVal);
    }
}
