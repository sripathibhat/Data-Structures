/**

Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

 

Example 1:

Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10
Example 2:

Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101

*/

class Solution {
    public int[] countBits(int n) {
        // Efficient solution
        int dp[] = new int[n + 1];
        // int i = 0, b = 1;
        // while (b <= n) {
        //     while(i < b && i + b <= n) {
        //         dp[i + b] = dp[i] + 1;
        //         i++;
        //     }
        //     i = 0;
        //     b <<= 1;
        // }

        int offset = 1;
        for (int i = 1; i <= n; i++) {
            if (offset * 2 == i) {
                offset = i;
            }
            dp[i] = 1 + dp[i - offset];
        }
        return dp;
    }
}
