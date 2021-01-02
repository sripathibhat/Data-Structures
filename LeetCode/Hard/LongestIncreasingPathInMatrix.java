// 329
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int dp[][] = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                max = Math.max(max, solve(i, j, matrix, dp));
            }
        }
        return max;
    }
    
    private int solve(int i, int j, int[][] matrix, int dp[][]) {
        int maxl = 0, maxr = 0, maxt = 0, maxb = 0;
        if(dp[i][j] != 0) {
            return dp[i][j];
        }
        if(i>0 && matrix[i-1][j] > matrix[i][j]) {
            maxt = solve(i-1, j, matrix, dp);
        }
        if(i<matrix.length-1 && matrix[i+1][j] > matrix[i][j]) {
            maxb = solve(i+1, j, matrix, dp);
        }
        if(j>0 && matrix[i][j-1] > matrix[i][j]) {
            maxl = solve(i, j-1, matrix, dp);
        }
        if(j<matrix[i].length-1 && matrix[i][j+1] > matrix[i][j]) {
            maxr = solve(i, j+1, matrix, dp);
        }
        dp[i][j] = 1 + Math.max(Math.max(maxl, maxr), Math.max(maxt, maxb));
        return dp[i][j];
    }
}