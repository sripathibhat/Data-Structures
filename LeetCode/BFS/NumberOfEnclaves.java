/**

ou are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

 

Example 1:


Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
Example 2:


Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
Output: 0
Explanation: All 1s are either on the boundary or can reach the boundary.

*/

class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Seed all boundary land cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1)
                        && grid[i][j] == 1) {
                    grid[i][j] = 0;          // mark as visited (sink it)
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // Step 2: BFS — flood-fill all land connected to boundary
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d: dirs) {
                int nr = cell[0] + d[0];
                int nc = cell[1] + d[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                    grid[nr][nc] = 0;  // sink it
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        // Step 3: Count remaining land cells (enclaves)
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}
