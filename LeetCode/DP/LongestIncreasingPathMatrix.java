/*

Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

Example 1:


Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:


Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
Example 3:

Input: matrix = [[1]]
Output: 1

*/

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = Integer.MIN_VALUE;
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(i, j, matrix, dp));
            }
        }
        return max;
    }

    private int dfs(int i, int j, int matrix[][], int dp[][]) {
        if (i < 0 || i > matrix.length - 1 || j < 0 || j > matrix[i].length - 1) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int maxTop = 0, maxBottom = 0, maxRight = 0, maxLeft = 0;
        if (i > 0 && matrix[i][j] < matrix[i - 1][j]) {
            maxTop = dfs(i - 1, j, matrix, dp);
        }
        if (i < matrix.length - 1 && matrix[i][j] < matrix[i + 1][j]) {
            maxBottom = dfs(i + 1, j, matrix, dp);
        }
        if (j > 0 && matrix[i][j] < matrix[i][j - 1]) {
            maxLeft = dfs(i, j - 1, matrix, dp);
        }
        if (j < matrix[i].length - 1 && matrix[i][j] < matrix[i][j + 1]) {
            maxRight = dfs(i, j + 1, matrix, dp);
        }
        dp[i][j] = 1 + Math.max(Math.max(maxTop, maxBottom), Math.max(maxLeft, maxRight));
        return dp[i][j];
    }
}
