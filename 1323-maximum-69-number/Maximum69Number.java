class Solution {
    public int maximum69Number (int num) {        
        int n = num;
        int index = -1;
        int currentDigit = 0;
      
        while(n > 0) {
            int dig = n % 10;
            
            if(dig == 6) {
                index = currentDigit;
            }
            
            currentDigit++;
            n /= 10;
        }
        
        if(index == -1) return num;
        
        int tens = (int)(Math.pow(10, index));
        return num + 3 * tens;
    }
}
