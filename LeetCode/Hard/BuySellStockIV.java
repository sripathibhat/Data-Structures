// 188
class Solution {
    
    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
        int dp[][][] = new int[prices.length+1][k+1][2];
        return helper(prices, 0, true, 0, k, dp);
    }
    
    private int helper(int prices[], int curIndex, boolean buy, int curTransactionCnt, int k, int dp[][][]) {
        if(curIndex == prices.length || curTransactionCnt >= k) {
            return 0;
        }
        int buyIndex = buy ? 1 : 0;
        if(dp[curIndex][curTransactionCnt][buyIndex] != 0) {
            return dp[curIndex][curTransactionCnt][buyIndex];
        }
        if(buy) {
            dp[curIndex][curTransactionCnt][buyIndex] = Math.max(-prices[curIndex] + helper(prices, curIndex+1, false, curTransactionCnt, k, dp), helper(prices, curIndex+1, buy, curTransactionCnt, k, dp));
        }
        else {  
            dp[curIndex][curTransactionCnt][buyIndex] = Math.max(prices[curIndex] + helper(prices, curIndex+1, true, curTransactionCnt+1, k, dp), helper(prices, curIndex+1, buy, curTransactionCnt, k, dp));
        }
        return dp[curIndex][curTransactionCnt][buyIndex];
    }
}