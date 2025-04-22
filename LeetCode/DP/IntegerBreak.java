/**

Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.

Return the maximum product you can get.
 

Example 1:

Input: n = 2
Output: 1
Explanation: 2 = 1 + 1, 1 × 1 = 1.


Example 2:

Input: n = 10
Output: 36
Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.

*/

class Solution {

    private Map<Integer, Integer> dp;

    public int integerBreak(int n) {

        // Top down DP

        // dp = new HashMap<>();
        // dp.put(1, 1);
        // return dfs(n, n);

        // Bottom up DP

        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int num = 2; num <= n; num++) {
            dp[num] = (num == n) ? 0 : num;
            for (int i = 1; i < num; i++) {
                dp[num] = Math.max(dp[num], dp[i] * dp[num - i]);
            }
        }

        return dp[n];

        // constant time solution
        // if (n == 2) {
        //     return 1;
        // } 
        // if (n == 3) {
        //     return 2;
        // }
        // int threes = n / 3;
        // if (n % 3 == 0) {
        //     return (int) Math.pow(3, threes);
        // }
        // if (n % 3 == 1) {
        //     return (int) Math.pow(3, threes - 1) * 4;
        // }
        // return (int) Math.pow(3, threes) * 2;
    }

    private int dfs(int num, int n) {
        if (dp.containsKey(num)) {
            return dp.get(num);
        }

        int res = (num == n) ? 0 : num;
        for (int i = 1; i < num; i++) {
            int val = dfs(i, n) * dfs(num - i, n);
            res = Math.max(res, val);
        }

        dp.put(num, res);
        return res;
    }
}
