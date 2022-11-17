class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);
        
        if(ax2 <= bx1 || ax1 >= bx2 || ay2 <= by1 || ay1 >= by2) {
            return area1 + area2;
        }
        
        int left = Math.max(ax1, bx1);
        int right = Math.min(ax2, bx2);
        int xOverlap = right - left;
        
        int bottom = Math.max(ay1, by1);
        int top = Math.min(ay2, by2);
        int yOverlap = top - bottom;
        
        int overlapArea = yOverlap * xOverlap;
        
        return area1 + area2 - overlapArea;
    }
}
