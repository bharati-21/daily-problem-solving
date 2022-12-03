class Solution {
    private int n;
    public String frequencySort(String s) {
        if(s == null || s.length() == 0) return "";
        
        n = s.length();
        
        // get frequency of every character
        Map<Character, Integer> frequency = new HashMap();
        findFrequencyOfCharacters(s, frequency);
        
        // At max the frequency would be n 
        // That is the entire string would contain only 1 character
        List<Character>[] bucket = new List[n+1];
        
        for(char ch: frequency.keySet()) {
            int count = frequency.get(ch);
            if(bucket[count] == null) {
                bucket[count] = new ArrayList();
            }
            bucket[count].add(ch);
        }
                
        StringBuilder sb = new StringBuilder();
        for(int c = n; c >= 0; c--) {
            if(bucket[c] == null) continue;
            
            List<Character> characters = bucket[c];
            for(char ch: characters) {
                int count = c;
                while(count-- > 0) {
                    sb.append(ch);
                }
            }
        }
        
        return sb.toString();
    }
    
    private void findFrequencyOfCharacters(String s,
                        Map<Character, Integer> frequency) {
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            frequency.put(ch, 
                          frequency.getOrDefault(ch, 0) + 1);
        }
    }
}
