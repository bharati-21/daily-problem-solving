class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        int result = 0;
        int number = 0;
        int sign = 1;
        int n = s.length();
        
        for(int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            
            if(curr == ' ') continue;
            if(curr >= '0' && curr <= '9') {
                // The number is not guaranteed to be single digit
                int j = i+1;
                number = (number * 10) + (curr - '0');
                while(j < n) {
                    char next = s.charAt(j);
                    if(next >= '0' && next <= '9') {
                        number = (number * 10) + (next - '0');
                        
                    }
                    else {
                        break;
                    }
                    j++;
                }
                i = j-1;
                result += (sign * number);
                
                sign = +1;
                number = 0;
            }
            else if(curr == '+') {
                sign = 1;
            }
            else if(curr == '-') {
                // This means that the next number will be subtracted from the result
                sign = -1;
            }
            else if(curr == '(') {
                stack.push(result);
                stack.push(sign);
                
                // reset the result and sign
                result = 0;
                sign = 1;
            }
            else {
                int stackTopSign = stack.pop();
                int stackTopResult = stack.pop();
                
                // pop the previos result and add/ subtract the intermediate values from result
                result = stackTopResult + (stackTopSign * result);
            }
        }
        
        return result;
    }
}
