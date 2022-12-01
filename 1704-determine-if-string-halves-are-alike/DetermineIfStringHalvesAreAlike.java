class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int half = n/2;
        int leftCount = 0, rightCount = 0;
        
        for(int left = 0, right = half; 
            left < half && right < n; 
            left++, right++) 
        {
            char leftCh = s.charAt(left);
            char rightCh = s.charAt(right);
            
            if(isVowel(leftCh)) {
                leftCount++;
            }
            if(isVowel(rightCh)) {
                rightCount++;
            }
        }
        
        return (leftCount == rightCount);
    }
    
    private boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || 
                ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O' || 
                ch == 'u' || ch == 'U'
        );
    }
}
