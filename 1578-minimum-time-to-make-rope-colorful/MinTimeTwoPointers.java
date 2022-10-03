class MinTimeTwoPointers {
    public int minCost(String colors, int[] neededTime) {
        if(colors == null || colors.length() == 0 || neededTime == null || neededTime.length == 0) {
            return 0;
        }
        
        int n = colors.length();
        int cost = 0;
                
        int maxVal = 0;
        int sum = 0;
        for(int left = 0, right = 0; right < n; ) {
            int leftColor = colors.charAt(left);
            int rightColor = colors.charAt(right);
            
            int rightTime = neededTime[right];
            
            if(leftColor == rightColor) {
                maxVal = Math.max(rightTime, maxVal);
                sum+=rightTime;
                
                right++;
            }
            else {
                // When the 2 colors differ then update cost
                cost += (sum - maxVal);
                sum = 0;
                maxVal = 0;
                left = right;
            }            
        }
        
        return cost + (sum-maxVal);
    }
}
