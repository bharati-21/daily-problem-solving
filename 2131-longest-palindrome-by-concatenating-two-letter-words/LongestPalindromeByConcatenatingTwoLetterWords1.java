class Solution {
    public int longestPalindrome(String[] words) {
        int n = words.length;
        
        Map<String, Integer> frequency = new HashMap();
        
        for(String word: words) {
            if(frequency.containsKey(word)) {
                int freq = frequency.get(word);
                frequency.put(word, freq+1);
            }
            else {
                frequency.put(word, 1);
            }
        }
        
        int count = 0;
        boolean usedSingleDoubleValue = false;
        
        for(String word: frequency.keySet()) {
            char first = word.charAt(0), second = word.charAt(1);
            int freq = frequency.get(word);
            if(first == second) {
                if(freq % 2 == 0) {
                    count += freq * 2;
                }
                else {
                    if(!usedSingleDoubleValue){
                        count += freq * 2;
                        usedSingleDoubleValue = true;
                    }
                    else {
                        count += (freq - 1) * 2;
                    }    
                }
            }
            else {
                String reversed = "" + second + first;
                if(frequency.containsKey(reversed)) {
                    int revFreq = frequency.get(reversed);
                    int min = Math.min(revFreq, freq);
                    
                    count += min*4;
                    frequency.put(word, freq-min);
                    frequency.put(reversed, revFreq-min);
                }
            }
            
        }
        
        return count;
    }
}
