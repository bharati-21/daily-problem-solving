class Solution {
    public String removeDuplicates(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        while(i < sb.length() - 1) {
            char curr = sb.charAt(i);
            char next = sb.charAt(i+1);
            
            if(next == curr) {
                sb.delete(i, i+2);
                if(i > 0) i -= 1;
            }
            else {
                i++;
            }
        }
        
        return sb.toString();
    }
}
