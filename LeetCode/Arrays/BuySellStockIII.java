/*

You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

*/

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int left[] = new int[n];
        int right[] = new int[n];
        int minLeft = prices[0];
        int maxRight = prices[n - 1];
        for(int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], prices[i] - minLeft);
            minLeft = Math.min(minLeft, prices[i]);
        }
        for(int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], maxRight - prices[i]);
            maxRight = Math.max(maxRight, prices[i]);
        }
        int maxProfit = 0;
        for(int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, left[i] + right[i]);
        }
        return maxProfit;
    }
}