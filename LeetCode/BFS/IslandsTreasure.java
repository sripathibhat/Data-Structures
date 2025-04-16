/**

You are given a m × n 2D grid initialized with these three possible values:

-1 - A water cell that can not be traversed.
0 - A treasure chest.
INF - A land cell that can be traversed. We use the integer 2^31 - 1 = 2147483647 to represent INF.
Fill each land cell with the distance to its nearest treasure chest. If a land cell cannot reach a treasure chest than the value should remain INF.

Assume the grid can only be traversed up, down, left, or right.

Modify the grid in-place.

Example 1:

Input: [
  [2147483647,-1,0,2147483647],
  [2147483647,2147483647,2147483647,-1],
  [2147483647,-1,2147483647,-1],
  [0,-1,2147483647,2147483647]
]

Output: [
  [3,-1,0,1],
  [2,2,1,-1],
  [1,-1,2,-1],
  [0,-1,3,4]
]
Example 2:

Input: [
  [0,-1],
  [2147483647,2147483647]
]

Output: [
  [0,-1],
  [1,2]
]

*/

class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<Pair> q = new LinkedList();
        int INF = 2147483647;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    q.add(new Pair(i, j, 0));
                }
            }
        }

        int dirs[][] = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        
        while (!q.isEmpty()) {
            Pair p = q.poll();
            for (int k = 0; k < dirs.length; k++) {
                int nx = p.x + dirs[k][0];
                int ny = p.y + dirs[k][1];
                int nd = p.d + 1;
                if (nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny] == INF) {
                    grid[nx][ny] = nd;
                    q.add(new Pair(nx, ny, nd));
                }
            }
        }
    }

    private class Pair {
        private int x;
        private int y;
        private int d;
        Pair(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
