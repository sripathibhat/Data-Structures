/*

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
*/

class Solution {
    public int numIslands(char[][] grid) {
        int cnt = 0;
        if(grid == null || grid.length == 0) {
            return cnt;
        }
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    cnt++;
                    // convert all 1's along the horizontal and vertical adjacent cells of this cell to 0 so that it won't get counted again
                    dfs(grid, i, j);
                }
            }
        }
        return cnt;
    }
    
    private void dfs(char grid[][], int i, int j) {
        if(i < 0 || j < 0 || i > grid.length - 1 || j > grid[i].length - 1 || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}