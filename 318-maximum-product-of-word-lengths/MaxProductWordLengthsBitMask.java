class MaxProductWordLengthsBitMask {
    public int maxProduct(String[] words) {
        int n = words.length;
        int maxLen = 0;
        
        int[] bitmasks = getWordMasks(words, n);
        
        // Compares every word i with every other word j. [0 <= i < j < n]
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
    
    private int[] getWordMasks(String[] words, int n) {
        int[] bitmasks = new int[n];
        
        for(int i = 0; i<n; i++) {
            String word = words[i];
            bitmasks[i] = generateWordMask(word);
        }
        
        return bitmasks;
    }
    
    private boolean compareCharacters(String firstWord, String secondWord, int firstBitMask, int secondBitMask) {
        return (firstBitMask & secondBitMask) == 0;
    }
    
    private int generateWordMask(String word) {
        int value = 0;
        int wordLen = word.length();

        for(int j = 0; j<wordLen; j++) {
            char ch = word.charAt(j);
            int position = getCharacterPositionInBit(ch);
            int mask = getCharacterMaskWithSetBit(position);
                
            // This creates a mask such that 
            // if ch = 'a' => 1
            // if ch = 'b' => 10
            // if ch = 'c' => 100
            // ...
            // if ch == 'z' => 1000...00 (25 0s)
            value |= mask;
        }
        
        return value;
    }
    
    private int getCharacterPositionInBit(char ch) {
        return ch - 'a';
    }
    
    private int getCharacterMaskWithSetBit(int position) {
        return 1 << position;
    }
}
