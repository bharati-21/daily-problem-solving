class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int maxLen = 0;
        int[] bitmasks = new int[n];
        
        for(int i = 0; i<n; i++) {
            int value = bitmasks[i];
            
            String word = words[i];
            int wordLen = word.length();
            for(int j = 0; j<wordLen; j++) {
                char ch = word.charAt(j);
                
                // This created a mask such that 
                // if ch = 'a' => 1
                // if ch = 'b' => 10
                // if ch = 'c' => 100
                // ...
                // if ch == 'z' => 1000...00 (25 0s)
                value |= (1 << ch - 'a');
            }
            bitmasks[i] = value;
        }
        
        for(int i = 0; i<n-1; i++) {
            String firstWord = words[i];
            for(int j = 0; j<n; j++) {
                String secondWord = words[j];
                
                if(compareCharacters(firstWord, secondWord, bitmasks[i], bitmasks[j])) {
                    int firstWordLen = firstWord.length();
                    int secondWordLen = secondWord.length();
                    int len = firstWordLen * secondWordLen;
                    maxLen = Math.max(len, maxLen);
                }
            }
        }
        
        return maxLen;
    }
    
    private boolean compareCharacters(String firstWord, String secondWord, int firstBitMask, int secondBitMask) {
        return (firstBitMask & secondBitMask) == 0;
    }
}
