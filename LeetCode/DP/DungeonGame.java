/*

The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of m x n
rooms laid out in a 2D grid. Our valiant knight was initially positioned in the top-left room and must fight his way through dungeon
to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons (represented by negative integers), so the knight loses health upon entering these rooms; other rooms are
either empty (represented as 0) or contain magic orbs that increase the knight's health (represented by positive integers).

To reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

Return the knight's minimum initial health so that he can rescue the princess.

Note that any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.

*/

// Reference - Coding decoded - https://github.com/Sunchit/Coding-Decoded
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        
        // bottom up DP
        // int m = dungeon.length;
        // int n = dungeon[0].length;
        // int dp[][] = new int[m + 1][n + 1];
        // for(int i = 0; i <= m; i++) {
        //     Arrays.fill(dp[i], Integer.MAX_VALUE);
        // }
        // dp[m - 1][n] = dp[m][n - 1] = 1;
        // for(int i = m - 1; i >= 0; i--) {
        //     for(int j = n - 1; j >= 0; j--) {
        //         int minPow = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
        //         dp[i][j] = minPow <= 0 ? 1 : minPow;
        //     }
        // }        
        // return dp[0][0];
        
        // top down DP
        Integer dp[][] = new Integer[dungeon.length][dungeon[0].length];
        return solve(dungeon, 0, 0 , dp);
    }

    // Naresh Gupta - memoization
    private int solve(int dungeon[][], int i, int j, Integer dp[][]) {
        if(dp[i][j] != null) {
            return dp[i][j];
        }
        int m = dungeon.length;
        int n = dungeon[0].length;
        if(i == m - 1 && j == n - 1) {
            return dp[i][j] = dungeon[i][j] > 0 ? 1 : 1 - dungeon[i][j];
        }
        if(i == m - 1) {
            return dp[i][j] = Math.max(1, solve(dungeon, i, j + 1, dp) - dungeon[i][j]);
        }
        if(j == n - 1) {
            return dp[i][j] = Math.max(1, solve(dungeon, i + 1, j, dp) - dungeon[i][j]);
        }
        return dp[i][j] = Math.max(1, Math.min(solve(dungeon, i + 1, j, dp), solve(dungeon, i, j + 1, dp)) - dungeon[i][j]);
    }
}