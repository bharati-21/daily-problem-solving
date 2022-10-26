class Solution {
  public boolean checkSubarraySum(int[] nums, int k) {
      if(nums == null || nums.length == 0) {
          return false;
      }

      int n = nums.length;

      HashMap<Integer, Integer> map = new HashMap();
      map.put(0, -1);
      int sum = 0;
      for(int i = 0; i<n; i++) {
          sum += nums[i];
          int remainder = sum % k;

          if(!map.containsKey(remainder) ) {
              map.put(remainder, i);
          }
          else {
              int j = map.get(remainder);
              if(i - j > 1) {
                  return true;
              }
          }
      }

      return false;
  }
}
