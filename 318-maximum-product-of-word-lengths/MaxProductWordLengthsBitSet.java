class MaxProductWordLengthsBitSet {
    public int maxProduct(String[] words) {
        int maxLen = 0;
        int n = words.length;
        boolean[][] frequency = new boolean[n][26];
                
        for(int i = 0; i<n; i++) {
            String word = words[i];
            
            for(int j = 0; j<word.length(); j++) {
                char ch = word.charAt(j);
                frequency[i][ch-'a'] = true;
            }
        }
        
        for(int i = 0; i<n-1; i++) {
            String firstWord = words[i];
            
            for(int j = i+1; j<n; j++) {
                String secondWord = words[j];
                int secondLen = secondWord.length();
                
                if(compareFrequency(firstWord, secondWord, frequency[i], frequency[j])) {
                    int firstWordLen = firstWord.length();
                    int secondWordLen = secondWord.length();
                    
                    int len = firstWordLen * secondWordLen;
                    maxLen = Math.max(maxLen, len);
                }
            }
        }
        return maxLen;
    }
    
    private boolean compareFrequency(String first, String second, boolean[] fWordFreq, boolean[] sWordFreq) {
        for(int i = 0; i<26; i++) {
            boolean firstFreq = fWordFreq[i];
            boolean secondFreq = sWordFreq[i];
            
            // If firstFreq and seconFreq are true, i.e. both contain the character i,
            // then they have a common character. We return false.
            if(firstFreq && secondFreq) {
                return false;
            }
        }
        
        // no common character found
        return true;
    }
}
