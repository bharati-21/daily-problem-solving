class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int num: nums) {
            if(num > 0) {
                set.add(num);
            }
        }
        
        int i = 1;
        for(; i<=n+1; i++) {
            if(!set.contains(i)) break;
        }
        
        return i;
    }
}
