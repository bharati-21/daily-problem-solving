class Solution {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
      if(nums == null || nums.length == 0) {
          return false;
      }

      int n = nums.length;
      Map<Integer, Integer> map = new HashMap();

      for(int i = 0; i<n; i++) {
          int num = nums[i];
          if(map.containsKey(num)) {
              int j = map.get(num);
              int diff = Math.abs(i-j);

              if(diff <= k) {
                  return true;
              }
          }

          // Update the index because any future occurrences
          // of the number could be within index [i, i+k]
          map.put(num, i);
      }

      return false;
  }
}
