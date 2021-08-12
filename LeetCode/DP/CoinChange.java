class Solution {
    public int coinChange(int[] coins, int amount) {
        // 2D DP
        // dp[i][j] => min no of coins to make an amount of 'j' when 'i' coins are available
        // dp[coins.length][amount] => min no of coins to make an amount of 'amount' when 'coins.length' coins are available => expected
        // int dp[][] = new int[coins.length + 1][amount + 1];
        // for(int i = 0; i <= coins.length; i++) {
        //     for(int j = 0; j <= amount; j++) {
        //         if(j == 0) {
        //             dp[i][j] = 0;
        //         }
        //         else if(i == 0) {
        //             dp[i][j] = Integer.MAX_VALUE - 1;
        //         }
        //         else {
        //             if(coins[i - 1] <= j) {
        //                 dp[i][j] = Math.min(1 + dp[i][j-coins[i-1]], dp[i - 1][j]);
        //             }
        //             else {
        //                 dp[i][j] = dp[i - 1][j];
        //             }
        //         }
        //     }
        // }
        // return dp[coins.length][amount] == Integer.MAX_VALUE - 1 ? -1 : dp[coins.length][amount];
        
        // 1D DP
        // dp[i] => min no of coins needed to make an amount of 'i'
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(coins[j] <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }
}