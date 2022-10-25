class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        if(word1 == null || word1.length == 0 || 
            word2 == null || word2.length == 0) {
            return false;
        }
        
        int m = word1.length, n = word2.length;
        int index1 = 0, index2 = 0;
        
        StringBuilder s1 = new StringBuilder(""), 
          s2 = new StringBuilder("");
        
        while(index1 < m || index2 < n) {
            if(index1 < m) {
                s1.append(word1[index1]);
                index1++;
            }
            if(index2 < n) {
                s2.append(word2[index2]);
                index2++;
            }
        }
        
        return s1.length() != s2.length() ? false : areEqual(s1, s2);
    }
    
    private boolean areEqual(StringBuilder s1, StringBuilder s2) {
        int n = s1.length();
        
        for(int i = 0; i<n; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            
            if(c1 != c2) return false;
        }
        
        return true;
    }
}
