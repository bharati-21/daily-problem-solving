class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int overlaps = 0;
        
        int n = img1.length;
        
        List<List<Integer>> listImg1 = getNonZeroPoints(img1);
        List<List<Integer>> listImg2 = getNonZeroPoints(img2);
        
        HashMap<Pair<Integer, Integer>, Integer> linearTrans = new HashMap(); 
        
        for(List<Integer> list1: listImg1) {
            for(List<Integer> list2: listImg2) {
                int r1 = list1.get(0), c1 = list1.get(1);
                int r2 = list2.get(0), c2 = list2.get(1);
                int rowDiff = r2-r1;
                int colDiff = c2-c1;
                
                Pair<Integer, Integer> p = new Pair(rowDiff, colDiff);
                
                if(linearTrans.containsKey(p)) {
                    linearTrans.put(p, linearTrans.get(p) + 1);
                }
                else {
                    linearTrans.put(p, 1);
                }
                
                overlaps = Math.max(overlaps, linearTrans.get(p));
            }
        }
        
        return overlaps;
    }
    
    private List<List<Integer>> getNonZeroPoints(int[][] a) {
        List<List<Integer>> list = new ArrayList();
        
        int n = a.length;
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                if(a[i][j] == 1) {
                    List<Integer> points = new ArrayList();
                    points.add(i);
                    points.add(j);
                    list.add(points);
                }
            }
        }
        
        return list;
    }
}
