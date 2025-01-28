/**

You are given a 0-indexed 2D matrix grid of size m x n, where (r, c) represents:

A land cell if grid[r][c] = 0, or
A water cell containing grid[r][c] fish, if grid[r][c] > 0.
A fisher can start at any water cell (r, c) and can do the following operations any number of times:

Catch all the fish at cell (r, c), or
Move to any adjacent water cell.
Return the maximum number of fish the fisher can catch if he chooses his starting cell optimally, or 0 if no water cell exists.

An adjacent cell of the cell (r, c), is one of the cells (r, c + 1), (r, c - 1), (r + 1, c) or (r - 1, c) if it exists.

Example 1:


Input: grid = [[0,2,1,0],[4,0,0,3],[1,0,0,4],[0,3,2,0]]
Output: 7
Explanation: The fisher can start at cell (1,3) and collect 3 fish, then move to cell (2,3) and collect 4 fish.
Example 2:


Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,1]]
Output: 1
Explanation: The fisher can start at cells (0,0) or (3,3) and collect a single fish. 

*/

class Solution {
    public int findMaxFish(int[][] grid) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    // DFS
                    res = Math.max(res, dfs(i, j, grid, visited));
                    // BFS
                    // res = Math.max(res, bfs(i, j, grid, visited));
                }
            }
        }
        return res;
    }

    private int dfs(int i , int j, int grid[][], boolean visited[][]) {
        if (i == grid.length || i < 0 || j == grid[i].length || j < 0 || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        int res = grid[i][j];
        res += dfs(i + 1, j, grid, visited) + dfs(i - 1, j, grid, visited) + dfs(i, j + 1, grid, visited) + dfs(i, j - 1, grid, visited);
        return res;
    }

    private int bfs(int i, int j, int grid[][], boolean visited[][]) {
        int dirs[][] = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i, j, grid[i][j]});
        int res = grid[i][j];
        visited[i][j] = true;
        while (!q.isEmpty()) {
            int rc[] = q.poll();
            for (int m = 0; m < dirs.length; m++) {
                int nr = rc[0] + dirs[m][0];
                int nc = rc[1] + dirs[m][1];
                if (nr == grid.length || nr < 0 || nc == grid[nr].length || nc < 0 || grid[nr][nc] == 0 || visited[nr][nc]) {
                    continue;
                }
                res += grid[nr][nc];
                q.add(new int[] {nr, nc});
                visited[nr][nc] = true;
            }  
        }
        return res;
    }
}

