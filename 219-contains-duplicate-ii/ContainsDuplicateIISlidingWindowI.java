class Solution {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
      if(nums == null || nums.length == 0) {
          return false;
      }

      int n = nums.length;
      Set<Integer> set = new HashSet();

      int left = 0, right = 0;
      while(right < n) {
          int num = nums[right];
          if(right - left > k) {
              set.remove(nums[left]);
              left++;
          }

          if(set.contains(num)) {
              return true;
          }
          set.add(num);
          right++;
      }

      return false;
  }
}
