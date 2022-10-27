class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int overlaps = 0;
        int n = img1.length;
        
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                overlaps = Math.max(overlaps, countOverlap(img1, img2, i, j));
                overlaps = Math.max(overlaps, countOverlap(img2, img1, i, j));
            }
        }
        
        return overlaps;
    }
    
    private int countOverlap(int[][] a, int[][] b, int rowStart, int colStart) {
        int n = a.length;
        int sumLeft = 0, sumRight = 0;
        int bRow = 0, bCol = 0;
        
        for(int aRow = rowStart; aRow<n; aRow++) {
            bCol = 0;
            
            for(int aCol = colStart; aCol<n; aCol++) {
                // Calculate when a is shifted to left
                if(a[aRow][aCol] == 1 && a[aRow][aCol] == b[bRow][bCol]) {
                    sumLeft++;
                }
                // calculate when a is shifted to right 
                // (or b shifted to left)
                if(a[aRow][bCol] == 1 && b[bRow][aCol] == a[aRow][bCol]) {
                    sumRight++;
                }
                bCol++;
            }
            bRow++;
        }

        return Math.max(sumLeft, sumRight); 
    }
}
