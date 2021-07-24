class Solution {
    public int orangesRotting(int[][] grid) {
        // BFS
        int m = grid.length;
        int n = grid[0].length;
        Queue<Point> q = new LinkedList();
        boolean freshOrangePresent = false;
       
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 2) {
                    q.add(new Point(i,j));
                }
                else if(grid[i][j] == 1) {
                    freshOrangePresent = true;
                }
            }
        }
        if(!freshOrangePresent) {
            // No fresh orranges, so nothing to rot
            return 0;
        }
        if(q.size()==0) {
            // There are fresh oranges but no rotten oranges, hence cannot rot fresh oranges
            return -1;
        }
        
        int mins = 0;
        int dirs[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!q.isEmpty()) {
            int size = q.size();
            boolean flag = false;
            for(int k=0; k<size; k++) {
                Point p = q.poll();
                for(int i=0; i<dirs.length; i++) {
                    int nx = p.x+dirs[i][0];
                    int ny = p.y+dirs[i][1];
                    if(nx>=0 && ny>=0 && nx<m && ny<n && grid[nx][ny] == 1) {
                        flag = true;
                        grid[nx][ny] = 2;
                        q.add(new Point(nx, ny));
                    }
                }
            }
            if(flag) {
                mins++;
            }
        }
        
        // check if there are still fresh oranges present, if yes, then return -1 as it is impossible to rot them
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        
        return mins;
    }
    
    private class Point {
        int x, y;
        Point(int i, int j) {
            x = i;
            y = j;
        }
    }
}