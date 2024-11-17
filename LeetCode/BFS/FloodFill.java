class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<Point> q = new LinkedList();
        int ocolor = image[sr][sc];
        q.add(new Point(sr, sc));
        int dir[][] = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int m = image.length;
        int n = image[0].length;
        image[sr][sc] = color;
        boolean visited[][]= new boolean[m][n];
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < dir.length; i++) {
                int nx = p.x + dir[i][0];
                int ny = p.y + dir[i][1];
                if (nx < 0 || ny < 0 || nx > m-1 || ny > n-1) {
                    continue;
                }
                if (image[nx][ny] == ocolor && !visited[nx][ny]) {
                    q.add(new Point(nx, ny));
                    image[nx][ny] = color;
                    visited[nx][ny] = true;
                }
            }
        }
        return image;
    }

    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
