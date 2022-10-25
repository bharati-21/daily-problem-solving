class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        if(word1 == null || word1.length == 0 || word2 == null || word2.length == 0) {
            return false;
        }
        
        int m = word1.length, n = word2.length;
        int index1 = 0, index2 = 0;
        int cp1 = 0, cp2 = 0; 
                
        while(index1 < m && index2 < n) {
            String w1 = word1[index1], w2 = word2[index2];
            int w1Len = w1.length(), w2Len = w2.length();
            
            char c1 = w1.charAt(cp1);
            char c2 = w2.charAt(cp2);
            
            if(!areCharsEqual(c1, c2)) {
                return false;
            }
            
            if(hasNext(cp1, w1Len)) {
                cp1++;
            }
            else {
                index1++;
                cp1 = 0;
            }
            
            if(hasNext(cp2, w2Len)) {
                cp2++;
            }
            else {
                index2++;
                cp2 = 0;
            }
        }
        
        return index1 == m && index2 == n;
    }
    
    private boolean areCharsEqual(char c1, char c2) {
        return c1 == c2;
    }
        
    private boolean hasNext(int index, int length) {
        return index < length-1;
    }
}
