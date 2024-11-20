/*

    A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

    The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid
    (marked 'Finish' in the diagram below).

    How many possible unique paths are there?

*/

class Solution {
    public int uniquePaths(int m, int n) {
        // bottom up DP or tabulation method
        // int dp[][] = new int[m][n];
        // for(int i = 0; i < m; i++) {
        //     for(int j = 0; j < n; j++) {
        //         if(i == 0 || j == 0) {
        //             dp[i][j] = 1;
        //         } else {
        //             dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        //         }
        //     }
        // }
        // return dp[m - 1][n - 1];

        // top down DP or memoization
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(m - 1, n - 1, m, n, dp);
    }

    private int solve(int i, int j, int m, int n, int dp[][]) {
        if (i == 0 || j == 0) {
            return 1;
        }
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int fromAbove = dp[i - 1][j] != -1 ? dp[i - 1][j] : solve(i - 1, j, m, n, dp);
        int fromLeft = dp[i][j - 1] != -1 ? dp[i][j - 1] : solve(i, j - 1, m, n, dp);
        dp[i][j] = fromLeft + fromAbove;
        return dp[i][j];
    }
}
