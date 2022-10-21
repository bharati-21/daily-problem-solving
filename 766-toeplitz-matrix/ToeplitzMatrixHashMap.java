class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        Map<Integer, Integer> map = new HashMap();

        int m = matrix.length, n = matrix[0].length;

        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                int curr = matrix[i][j];
                int diagonalNum = i-j;

                if(map.containsKey(diagonalNum)) {
                    int diagVal = map.get(diagonalNum);
                    if(diagVal != curr) {
                        return false;
                    }
                }
                else {
                    map.put(diagonalNum, curr);
                }
            }
        }
        return true;
    }
}
