class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0) {
            return "";
        }
        
        String substring = "";
        int m = s.length(), n = t.length();
        Map<Character, Integer> mapT = new HashMap();
        
        for(int i = 0; i<n; i++) {
            char ch = t.charAt(i);
            mapT.put(ch, mapT.getOrDefault(ch, 0) + 1);
        }
        
        int left = 0, right = 0;
        
        Map<Character, Integer> mapS = new HashMap();
        
        // O(m) m = len(s)
        while(right < m) {
            char ch = s.charAt(right);
            if(!mapS.containsKey(ch)) {
                mapS.put(ch, 0);
            }
            int c = mapS.get(ch);
            mapS.put(ch, c+1);

            boolean isEqual = checkIfEqual(mapT, mapS);
            if(isEqual) {
                while(left <= right && checkIfEqual(mapT, mapS)) {
                    String newS = s.substring(left, right+1);
                    if(substring.isEmpty() || newS.length() < substring.length()) {
                        substring = newS;
                    }
                    removeChar(mapS, s.charAt(left));
                    left++;
                }
            }
            right++;
        }
                
        return substring;
    }
    
    // O(n) n = len(t)
    private void removeChar(Map<Character, Integer> map, char left) {
        if(map.containsKey(left)) {
            if(map.get(left) == 1) {
                map.remove(left);
            }
            else {
                int c = map.get(left);
                map.put(left, c-1);
            }
        }
    }
    
    private boolean checkIfEqual(Map<Character, Integer> m1, Map<Character, Integer> m2) {
        for(char ch: m1.keySet()) {
            if(m2.containsKey(ch)) {
                if(m2.get(ch) < m1.get(ch)) {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        
        return true;
    }
}
