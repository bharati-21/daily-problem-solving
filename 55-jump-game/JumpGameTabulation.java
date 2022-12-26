class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        
        /*
            If the max jump from 0th index is 0 and 
            number of elements is greater than 1, 
            then can never reach the last element
        */
        if(n > 1 && nums[0] == 0) {
            return false;
        }
        
        boolean[] canReach = new boolean[n];
        
        // can reach last element from last element
        canReach[n-1] = true; 
        
        for(int i = n-2; i >= 0; i--) {
            int maxJump = nums[i];
            int j = i+1;
            int lastJumpIndex = maxJump + i;
            
            while(j < n && j <= lastJumpIndex) {
                boolean canReachFromHere = canReach[j];
                if(canReachFromHere) {
                    canReach[i] = true;
                }
                j++;
            }
        }
        
        return canReach[0];
    }
}
