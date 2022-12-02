class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        
        int n = word1.length();
        
        int[] frequencyWordOne = new int[26];
        int[] frequencyWordTwo = new int[26];
        
        for(int i = 0; i<n; i++) {
            char ch = word1.charAt(i);
            frequencyWordOne[ch - 'a']++;
        }
        
        for(int i = 0; i<n; i++) {
            char ch = word2.charAt(i);
            if(frequencyWordOne[ch - 'a'] == 0) {
                return false;
            }
            frequencyWordTwo[ch - 'a']++;
        }
        
        Arrays.sort(frequencyWordOne);
        Arrays.sort(frequencyWordTwo);
        
        for(int i = 0; i<26; i++) {
            if(frequencyWordOne[i] != frequencyWordTwo[i]) {
                return false;
            }
        }
        
        return true;
    }
}
