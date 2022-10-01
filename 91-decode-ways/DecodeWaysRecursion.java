class DecodeWaysRecursion {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
		    return 0;
        }
        return decode(s);
    }
	
	private int decode(String s) {
		int n = s.length();
		// You've found 1 way to decode
		if(n == 0) {
			return 1;
        }

        char firstChar = s.charAt(0);
        // If the first character is 0, you cannot break down the string further
        if(firstChar == '0') {
	        return 0;
        }

        // Choose only 1 character or choose 2 characters
        int chooseOneChar = decode(s.substring(1));
        
        int chooseTwoChar = 0;
        if(isValidString(s, 2, n)) {
            // validate if you can select 2 characters
            chooseTwoChar = decode(s.substring(2));
        }
        return chooseOneChar + chooseTwoChar;
    }

    private boolean isValidString(String s, int numChars, int n) {
        // Only if n > 1, you can choose 2 characters
        if(n > 1) {
            String firstTwoChars = s.substring(0,2);
            
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
