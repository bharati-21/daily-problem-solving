class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] cap = new int[n];
        int fullBags = 0;
        
        for(int i = 0; i<n; i++) {
            cap[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(cap);
        
        for(int i = 0; i<n; i++) {
            int currCap = cap[i];
            if(currCap == 0) {
                fullBags++;
                continue;
            }
            
            if(currCap <= additionalRocks) {
                additionalRocks -= currCap;
                fullBags++;
            }
            else {
                break;
            }
        }
        
        return fullBags;
    }
}
