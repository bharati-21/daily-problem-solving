class Solution {
  public boolean checkIfPangram(String sentence) {
      if(sentence == null || sentence.length() == 0) {
          return false;
      }

      int[] count = new int[26];
      int n = sentence.length();

      for(int i = 0; i<n; i++) {
          char ch = sentence.charAt(i);
          count[ch-'a']++;
      }

      for(int c: count) {
          if(c == 0) {
              return false;
          }
      }

      return true;
  }
}
