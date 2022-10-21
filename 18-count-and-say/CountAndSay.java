class Solution {
  public String countAndSay(int n) {
      if(n == 1) {
          return "1";
      }

      String prevCount = countAndSay(n-1);
      String currentSay = say(prevCount);

      return currentSay;
  }

  private String say(String s) {
      char[] countArr = s.toCharArray();
      int count = 1;
      char prev = countArr[0];
      int n = countArr.length;

      StringBuilder sb = new StringBuilder();
      for(int i = 1; i<=n; i++) {
          if(i == n) {
              sb.append(count + "" + prev);
              break;
          }
          char ch = countArr[i];
          if(ch == prev) {
              count++;
          }
          else {
              // add the count and num to the sb
              sb.append(count + "" + prev);
              prev = ch;
              count = 1;
          }
      }

      return sb.toString();
  }
}
