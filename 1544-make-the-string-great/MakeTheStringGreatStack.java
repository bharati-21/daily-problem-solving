class Solution {
    public String makeGood(String s) {
        if(s == null || s.length() <= 0) {
            return s;
        }
        
        int n = s.length();
        int i = 0;
        
        StringBuilder greatString = new StringBuilder(s);
        while(i < greatString.length()-1) {
            char curr = greatString.charAt(i);
            char next = greatString.charAt(i+1);
        
            // If the strings are not same letter but in difference cases
            if(curr - 'a' == next - 'A' || curr - 'A' == next - 'a') {
                greatString.delete(i, i+2);
                if(i > 0) i-=1;
            }
            else {
                i++;
            }
            
        }
        
        
        return greatString.toString();
    }
}
