class DecodeWaysTabulation {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
		    return 0;
        }
        
        int n = s.length();
        
        // memoize results here
        int[] tabulation = new int[n];
        
        // This is going to be the prevChar at i
        char prevChar = s.charAt(0);
        
        tabulation[0] = isZero(prevChar) ? 0 : 1;
        
        for(int i = 1; i<n; i++) {
            char currChar = s.charAt(i);
            int chooseOne = isZero(currChar) ? 0 : tabulation[i-1];
            
            int chooseTwo = 0;
            // If it's valid to choose 2 strings.
            if(isValid(prevChar, currChar)) {
                // If i == 1, then you know that the number of ways to decode 
                // selecting prevChar and currChar is 1 (0th, 1st char)
                chooseTwo = (i > 1) ? tabulation[i-2] : 1;
            }
            
            tabulation[i] = chooseOne + chooseTwo;
            prevChar = currChar;
        }
        
        return tabulation[n-1];
    }
    
    private boolean isZero(char ch) {
        return ch =='0';
    }

    private boolean isValid(char first, char second) {
        return (first == '1') || (first == '2' && second < '7');
    }
}

