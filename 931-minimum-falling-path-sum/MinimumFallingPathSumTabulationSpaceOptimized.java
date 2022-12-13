class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int n = matrix.length;        
        int[] prev = new int[n], curr = new int[n];
        
        // base case
        for(int j = 0; j<n; j++) prev[j] = matrix[0][j];
        
        for(int j = 0; j<n; j++) {
            curr[j] = Integer.MAX_VALUE;
        }
        
        for(int i = 1; i<n; i++) {
            for(int j = 0; j<n; j++) {
                int top = prev[j];
                int leftDiag = (j >= 1) ? prev[j-1] : Integer.MAX_VALUE;
                int rightDiag = (j < n-1) ? prev[j+1] : Integer.MAX_VALUE;
                int diagMin = Math.min(leftDiag, rightDiag);
                
                curr[j] = matrix[i][j] + Math.min(diagMin, top);
            }
            prev = curr.clone();
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++) min = Math.min(min, prev[i]);
        return min;
    }
}
