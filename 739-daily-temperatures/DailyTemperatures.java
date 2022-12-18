class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0) {
            return new int[0];
        }
        
        int n = temperatures.length;
        int[] warmerDaysWait = new int[n];
        
        Stack<Integer> warmerDayIndices = new Stack();
        
        for(int i = n-1; i >= 0; i--) {
            int temperature = temperatures[i];
            
            if(warmerDayIndices.isEmpty()) {
                warmerDaysWait[i] = 0;
            }
            else {
                while(!warmerDayIndices.isEmpty()) {
                    int topIndex = warmerDayIndices.peek();
                    if(temperature >= temperatures[topIndex]) {
                        warmerDayIndices.pop();
                    }
                    else {
                        break;
                    }
                }
                
                if(warmerDayIndices.isEmpty()) {
                    warmerDaysWait[i] = 0;
                }
                else {
                    warmerDaysWait[i] = warmerDayIndices.peek() - i;
                }
            }
            
            warmerDayIndices.push(i);
        }
        
        return warmerDaysWait;
    }
}
