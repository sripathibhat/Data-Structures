/**

Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance
to the nearest land cell is maximized, and return the distance. If no land or water exists in the grid, return -1.

The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.

Example 1:

Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
Output: 2
Explanation: The cell (1, 1) is as far as possible from all the land with distance 2.

Example 2:

Input: grid = [[1,0,0],[0,0,0],[0,0,0]]
Output: 4
Explanation: The cell (2, 2) is as far as possible from all the land with distance 4.

*/


class Solution {
    public int maxDistance(int[][] grid) {
        Queue<int[]> q = new LinkedList();
        int n = grid.length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    q.add(new int[] {i, j});
                }
            }
        }
        if (q.isEmpty() || q.size() == n * n) {
            return -1;
        }
        int max = 0;
        int dirs[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cell[] = q.poll();
                int x = cell[0];
                int y = cell[1];
                for (int k = 0; k < dirs.length; k++) {
                    int nx = cell[0] + dirs[k][0];
                    int ny = cell[1] + dirs[k][1];
                    if (isValid(nx, ny, grid) && grid[nx][ny] == 0) {
                        grid[nx][ny] = grid[x][y] + 1;
                        max = Math.max(max, grid[nx][ny] - 1);
                        q.add(new int[] {nx, ny});
                    }
                }
            }
        }
        return max;
    }

    private boolean isValid(int i, int j, int grid[][]) {
            return i >= 0 && j >= 0 && i < grid.length && j < grid[i].length;
        }
}

 /**
    (0, 0), (0, 2)
    (1, 1)
*/

