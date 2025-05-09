/*

Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25

*/

class Solution {
    public double myPow(double x, int n) {
        double res = 1.0;
        long nn = n;
        if (nn < 0) {
            // conver nn to positive
            nn = -1 * nn;
        }
        while (nn > 0) {
            if (nn % 2 == 0) {
                x = x * x;
                nn = nn / 2;
            } else {
                res = res * x;
                nn = nn - 1;
            }
        }
        if (n < 0) {
            res = 1 / res;
        }
        return res;
    }
}

