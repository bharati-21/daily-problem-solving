class Solution {
    private int n;
    Map<Integer, Integer>[] map;
    public int numberOfArithmeticSlices(int[] nums) {
        n = nums.length;
        if(n < 3) return 0;
        
        long numSlices = 0;
        map = new Map[n];
        
        for(int i = 0; i<n; i++) map[i] = new HashMap<>();
        
        for(int i = 1; i<n; i++) {
            for(int j = 0; j<i; j++) {
                double difference = (double) nums[i] - (double) nums[j];
                int diff = (int) difference;
                
                int sum = 0, origin = 0;
                if(map[j].containsKey(diff)) {
                    sum = map[j].get(diff);
                }
                if(map[i].containsKey(diff)) {
                    origin = map[i].get(diff);
                }

                map[i].put(diff, origin + sum + 1);
                numSlices += sum;
            }
        }
        
        return (int) numSlices;
        
    }
}
