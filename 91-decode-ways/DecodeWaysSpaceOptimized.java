class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
		    return 0;
        }
        
        int n = s.length();
        
        char prevChar = s.charAt(0);
        int first = (prevChar == '0') ? 0 : 1;
        int second = 1;
        
        for(int i = 1; i<n; i++) {
            char currChar = s.charAt(i);
            int chooseOne = isZero(currChar) ? 0 : first;
            int chooseTwo = 0;
            
            // If it's valid to choose first 2 strings
            if(isValid(prevChar, currChar)) {
                chooseTwo = second;
            }
            
            // update first, second, and prevChar
            second = first;
            first = chooseOne + chooseTwo;
            prevChar = currChar;
        }
        
        return first;
    }
    
    private boolean isZero(char ch) {
        return ch =='0';
    }

    private boolean isValid(char first, char second) {
        return (first == '1') || (first == '2' && second < '7');
    }
}

