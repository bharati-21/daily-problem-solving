class Solution {
  public boolean checkIfPangram(String sentence) {
      if(sentence == null || sentence.length() == 0) {
          return false;
      }

      int n = sentence.length();
      Set<Character> set = new HashSet();

      for(int i = 0; i<n; i++) {
          char ch = sentence.charAt(i);
          set.add(ch);
      }

      return set.size() == 26;
  }
}
