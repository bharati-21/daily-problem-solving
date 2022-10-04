class MaxProductWordLengthsFreqCount {
    public int maxProduct(String[] words) {
        int maxLen = 0;
        int n = words.length;
        List<int[]> frequencyList = new ArrayList<>();
        
        for(String word: words) {
            int[] frequency = new int[26];
            for(int i = 0; i<word.length(); i++) {
                char ch = word.charAt(i);
                frequency[ch-'a']++;
            }
            frequencyList.add(frequency);
        }
        
        for(int i = 0; i<n-1; i++) {
            String first = words[i];
            int firstLen = first.length();
            
            for(int j = i+1; j<n; j++) {
                String second = words[j];
                int secondLen = second.length();
                
                if(compareFrequency(first, second, frequencyList.get(i), frequencyList.get(j))) {
                    int len = firstLen * secondLen;
                    maxLen = Math.max(maxLen, len);
                }
                
                
            }
        }
        return maxLen;
    }
    
    private boolean compareFrequency(String first, String second, int[] firstFreq, int[] secondFreq) {
        for(int i = 0; i<26; i++) {
            int secondCount = secondFreq[i];
            int firstCount = firstFreq[i];
            
            // If both have the character, then the count will be greater than 0
            if(firstCount > 0 && secondCount > 0) {
                return false;
            }
        }
        return true;
    }
}
