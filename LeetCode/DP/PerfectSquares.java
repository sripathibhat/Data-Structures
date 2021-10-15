/*

    Given an integer n, return the least number of perfect square numbers that sum to n.

    A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself.
    For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

*/

class Solution {
    public int numSquares(int n) {
        
        // 2D dp
//         int len = (int) Math.sqrt(n);
//         int T[][] = new int[len + 1][n + 1];
        
//         for(int i = 0; i <= len; i++) {
//             T[i][0] = 0;
//         }
//         for(int j = 1; j <= n; j++) {
//             T[0][j] = Integer.MAX_VALUE - 1;
//         }
//         for(int i = 1; i <= len; i++) {
//             for(int j = 1; j <= n; j++) {
//                 if(i*i <= j) {
//                     T[i][j] = Math.min(T[i - 1][j], 1 + T[i][j - i*i]);
//                 } else {
//                     T[i][j] = T[i - 1][j];
//                 }
//             }
//         }
//         return T[len][n];
        
        // 1D dp
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}