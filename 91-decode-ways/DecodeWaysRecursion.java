class DecodeWaysRecursion {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
		    return 0;
        }
        
        int n = s.length();
        int[] memoized = new int[n];
        // We fill the memoized indices with -1, so that we can differentiate
        // between solved and unsolved sub-problems
        Arrays.fill(memoized, -1);
        
        return decodeMemoized(s, 0, memoized);
    }
	
	private int decodeMemoized(String s, int index, int[] memoized) {
        int n = s.length();

		// You've found 1 way to decode
		if(index == n) {
			return 1;
        }
        
        // If the sub-problem was already solved, return memoized answer
        if(memoized[index] != -1) {
            return memoized[index];
        }
        
        char firstChar = s.charAt(index);
        // If the character at index is 0, you cannot break down the string further
        if(firstChar == '0') {
            memoized[index] = 0;
	        return 0;
        }
        

        // Choose only 1 character or choose 2 characters
        int chooseOneChar = decodeMemoized(s, index+1, memoized);
        
        int chooseTwoChar = 0;
        if(isValidString(s, index, 2, n)) {
            // validate if you can select 2 characters
            chooseTwoChar = decodeMemoized(s, index+2, memoized);
        }
        memoized[index] = chooseOneChar + chooseTwoChar;
        return memoized[index];
    }

    private boolean isValidString(String s, int index, int numChars, int n) {
        // Only if index < n-1, you can choose 2 characters
        if(index < n-1) {
            String firstTwoChars = s.substring(index, index+2);
            
            char firstChar = firstTwoChars.charAt(0);
            char secondChar =  firstTwoChars.charAt(1);
            
            // If the string is of the form "1x" or "2x", then you this is a valid group
            if(firstChar == '1' || firstChar == '2' && secondChar < '7') {
                return true;
            }
        }
        return false;
    }

}

