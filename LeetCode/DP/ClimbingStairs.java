/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

*/

class Solution {
    public int climbStairs(int n) {

        // this also will work
        // int dp[] = new int[n];
        // dp[0] = 1;
        // if(n == 1) {
        //     return dp[n - 1];
        // }
        // dp[1] = 2;
        // for(int i = 3; i <= n; i++) {
        //     dp[i-1] = dp[i-2] + dp[i-3];
        // }
        // return dp[n-1];
        
        int T[] = new int[n + 1];
        for(int i = 1; i <= n;i++) {
            if(i <= 2) T[i] = i;
            else T[i] = T[i - 1] + T[i - 2];
        }
        return T[n];
    }
}