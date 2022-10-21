class Solution {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
      if(nums == null || nums.length == 0) {
          return false;
      }

      int n = nums.length;

      for(int i = 0; i < n-1; i++) {
          int n1 = nums[i];
          for(int j = i+1; j < n; j++) {
              int n2 = nums[j];
              if(n1 != n2) {
                  continue;
              }

              int diff = Math.abs(i-j);
              if(diff <= k) {
                  return true;
              }
          }
      }

      return false;
  }
}
