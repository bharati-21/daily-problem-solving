class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int[][] outerTrees(int[][] trees) {
        if(trees.length == 1) return trees;
       
        List<Point> points = new ArrayList<>();
       
        for(int[] tree: trees) {
            Point p = new Point(tree[0], tree[1]);
            points.add(p);
        }
        int n = points.size();
       
        Collections.sort(points, (a,b) -> a.x == b.x ? a.y - b.y : a.x - b.x);
        Set<List<Integer>> duplicates = new HashSet();
       
        Stack<Point> hull = new Stack();
        hull.push(points.get(0));
        hull.push(points.get(1));
       
        for(int i = 2; i<n; i++) {
            Point top = hull.pop();
            while(!hull.isEmpty() && checkAngles(hull.peek(), top, points.get(i)) < 0) {
                top = hull.pop();
            }
            hull.push(top);
            hull.push(points.get(i));
        }

        for(int i = n-2; i>=0; i--) {
            Point top = hull.pop();
            while(!hull.isEmpty() && checkAngles(hull.peek(), top, points.get(i)) < 0) {
                top = hull.pop();
            }
            hull.push(top);
            hull.push(points.get(i));
        }
        
        List<Point> answer = new ArrayList();
        int index = 0;
        for(Point p: hull) {
            ArrayList<Integer> temp = new ArrayList();
            temp.add(p.x);
            temp.add(p.y);
            
            if(duplicates.contains(temp)) continue;
            duplicates.add(temp);
            answer.add(p);
        }
       
        int[][] ans = new int[answer.size()][2];
        int i = 0;
        
        for(Point p: answer) {
            ans[i][0] = p.x;
            ans[i][1] = p.y;
            i++;
        }
        
        return ans;
    }
   
    private int checkAngles(Point p, Point q, Point r) {
        return (q.x - p.x) * (r.y - p.y) - (q.y - p.y)* (r.x - p.x);
    }
}
