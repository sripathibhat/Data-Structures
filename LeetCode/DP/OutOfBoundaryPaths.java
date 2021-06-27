class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        // Each entry in dp array dp[i][j][k] - number of ways to reach the outside of the boundary from [i, j] with k number of moves
        // maxMove to reach out of boundary from i,j = maxMove - 1 moves to reach out of boundary from all 4 of its neighbouring entries
        // i.e. dp[i][j][maxMove] = dp[i-1][j][maxMove-1] + dp[i+1][j][maxMove-1] + dp[i][j-1][maxMove-1] + dp[i][j+1][maxMove-1]
        long dp[][][] = new long[m + 1][n + 1][maxMove + 1];
        for(int i = 0; i < m+1; i++) {
            for(int j = 0; j < n+1; j++) {
                for(int k = 0; k < maxMove+1; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        
        return (int)solve(m, n, maxMove, startRow, startColumn, dp);
    }
    
    private long solve(int m, int n, int maxMove, int i, int j, long dp[][][]) {
        if(i < 0 || j < 0 || i >= m || j >= n) {
            return 1;
        }
        if(maxMove <= 0) {
            return 0;
        }
        
        if(dp[i][j][maxMove] != -1) {
            return dp[i][j][maxMove];
        }
        long total = 0;
        long up = solve(m, n, maxMove - 1, i - 1, j, dp);
        long down = solve(m, n, maxMove - 1, i + 1, j, dp);
        long left = solve(m, n, maxMove - 1, i, j - 1, dp);
        long right = solve(m, n, maxMove - 1, i, j + 1, dp);
        dp[i][j][maxMove] = (up + down + left + right) % 1000000007;
        return dp[i][j][maxMove];
    }
}