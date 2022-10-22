class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0) {
            return "";
        }
        
        String substring = "";
        int m = s.length(), n = t.length();
        Map<Character, Integer> mapT = new HashMap();
        
        // O(n)
        for(int i = 0; i<n; i++) {
            char ch = t.charAt(i);
            mapT.put(ch, mapT.getOrDefault(ch, 0) + 1);
        }
        
        // This is the number of unique characters in T 
        // that are required in the min substring
        int numUniqueCharsRequired = mapT.size();
        
        int left = 0, right = 0, numUniqueCharsFormed = 0;
        Map<Character, Integer> mapS = new HashMap();
        
        int smallestWindow = -1;
        int start = -1;
        int end = -1;
        
        while(right < m) {
            char ch = s.charAt(right);
            if(!mapS.containsKey(ch)) {
                mapS.put(ch, 0);
            }
            int c = mapS.get(ch)+1;
            mapS.put(ch, c);
    
            if(mapT.containsKey(ch) && mapT.get(ch) == c) {
                numUniqueCharsFormed++;
            }
            
            while(left <= right && numUniqueCharsFormed == numUniqueCharsRequired) {
                char leftC = s.charAt(left);
                int currWindow = right - left + 1;
                if(smallestWindow == -1 || currWindow < smallestWindow) {
                    smallestWindow = currWindow;
                    start = left;
                    end = right;
                }
                    
                mapS.put(leftC, mapS.get(leftC)-1);
                // check if the removed left most char
                // still matches in the current window
                if(mapT.containsKey(leftC) && mapT.get(leftC) > mapS.get(leftC)) {
                    numUniqueCharsFormed--;
                }
                
                // increment the window from the left
                left++;
            }
            
            right++;
        }
                
        return smallestWindow == -1 ? "" : s.substring(start, end+1);
    }
}
