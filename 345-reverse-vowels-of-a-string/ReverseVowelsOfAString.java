class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        
        char[] reversed = s.toCharArray();
        
        int n = s.length();
        int i = 0, j = n-1;
        
        while(i < j) {
            char left = reversed[i];
            char right = reversed[j];
            
            boolean isLeftCharVowel = isVowel(left);
            boolean isRightCharVowel = isVowel(right);
            
            if(!isLeftCharVowel && !isRightCharVowel) {
                i++;
                j--;
            }
            else if(!isLeftCharVowel) {
                i++;
            }
            else if(!isRightCharVowel) {
                j--;
            }
            else {
                swap(i, j, reversed);
                i++;
                j--;
            }
        }
        
        return new String(reversed);
    }
    
    private boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' 
               || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U');
    }
    
    private void swap(int left, int right, char[] reversed) {
        char temp = reversed[left];
        reversed[left] = reversed[right];
        reversed[right] = temp;
    }
}
