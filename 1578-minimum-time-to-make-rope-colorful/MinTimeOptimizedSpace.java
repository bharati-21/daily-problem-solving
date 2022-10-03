class MinTimeOptimizedSpace {
    public int minCost(String colors, int[] neededTime) {
        if(colors == null || colors.length() == 0 || neededTime == null || neededTime.length == 0) {
            return 0;
        }
        
        int n = colors.length();
        int cost = 0;
    
        for(int i = 0; i<n; ) {
            char color = colors.charAt(i);
            int j = i+1;
            
            int maxVal = neededTime[i];
            int sum = neededTime[i];
            
            // Process until you reach a value that does not have the same color as colors[i]
            while(j < n && color == colors.charAt(j)) {
                int currTime = neededTime[j];
                maxVal = Math.max(currTime, maxVal);
                sum += currTime;
                j++;
            }
            
            // Remove the largest neededTime among the list of colors [i, i+j]
            cost += sum-maxVal;
            i = j;
        }
        return cost;
    }
}
