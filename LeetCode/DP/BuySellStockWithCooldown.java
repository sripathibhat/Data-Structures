/*

    You are given an array prices where prices[i] is the price of a given stock on the ith day.

    Find the maximum profit you can achieve. You may complete as many transactions as you like
    (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

    After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
    Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

*/

class Solution {
    public int maxProfit(int[] prices) {
        int bm[] = new int[prices.length];
        int sm[] = new int[prices.length];
        return buy(prices, 0, bm, sm);
    }

    private int buy(int prices[], int i, int[] bm, int[] sm) {
        if(i >= prices.length) {
            return 0;
        }
        if(bm[i] != 0) {
            return bm[i];
        }
        bm[i] = Math.max(-prices[i] + sell(prices, i + 1, bm, sm), buy(prices, i + 1, bm, sm));
        return bm[i];
    }

    private int sell(int prices[], int i, int[] bm, int[] sm) {
        if(i >= prices.length) {
            return 0;
        }
        if(sm[i] != 0) {
            return sm[i];
        }
        sm[i] = Math.max(prices[i] + buy(prices, i + 2, bm, sm), sell(prices, i + 1, bm, sm));
        return sm[i];
    }
}