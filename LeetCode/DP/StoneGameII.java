/**
Alice and Bob continue their games with piles of stones. There are a number of piles arranged in a row, and each pile has a positive integer
number of stones piles[i]. The objective of the game is to end with the most stones.

Alice and Bob take turns, with Alice starting first.

On each player's turn, that player can take all the stones in the first X remaining piles, where 1 <= X <= 2M. Then, we set M = max(M, X). Initially, M = 1.

The game continues until all the stones have been taken.

Assuming Alice and Bob play optimally, return the maximum number of stones Alice can get.
 

Example 1:

Input: piles = [2,7,9,4,4]

Output: 10

Explanation:

If Alice takes one pile at the beginning, Bob takes two piles, then Alice takes 2 piles again. Alice can get 2 + 4 + 4 = 10 stones in total.
If Alice takes two piles at the beginning, then Bob can take all three piles left. In this case, Alice get 2 + 7 = 9 stones in total.
So we return 10 since it's larger.

Example 2:

Input: piles = [1,2,3,4,5,100]

Output: 104

*/

class Solution {
    public int stoneGameII(int[] piles) {
        int dp[][][];
        int n = piles.length;
        dp = new int[2][n][n + 1];
        for (int layer[][]: dp) {
            for (int row[]: layer) {
                Arrays.fill(row, -1);
            }
        }
        return dfs(1, 0, 1, piles, dp);
    }

    private int dfs(int alice, int i, int M, int piles[], int dp[][][]) {
        if (i == piles.length) {
            return 0;
        }
        if (dp[alice][i][M] != -1) {
            return dp[alice][i][M];
        }
        int res = alice == 1 ? 0 : Integer.MAX_VALUE;
        int total = 0;
        for (int X = 1; X <= 2 * M; X++) {
            if (i + X > piles.length) {
                break;
            }
            total += piles[i + X - 1];
            if (alice == 1) {
                res = Math.max(res, total + dfs(0, i + X, Math.max(M, X), piles, dp));
            } else {
                res = Math.min(res, dfs(1, i + X, Math.max(M, X), piles, dp));
            }
        }
        dp[alice][i][M] = res;
        return res;
    }
}
