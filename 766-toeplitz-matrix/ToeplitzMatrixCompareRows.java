class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        for(int i = 0; i<m-1; i++) {
            for(int j = 0; j<n; j++) {
                int curr = matrix[i][j];
                if(j+1 < n) {
                    int prev = matrix[i+1][j+1];
                    if(curr != prev) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
