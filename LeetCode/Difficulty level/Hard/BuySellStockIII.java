// 123
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
        
        // below code works
        // int s1 = -prices[0], s2 = 0, s3 = Integer.MIN_VALUE, s4 = 0;
        // for(int i=1; i<prices.length; i++) {
        //     s1 = Math.max(s1, -prices[i]);
        //     s2 = Math.max(s2, s1+prices[i]);
        //     s3 = Math.max(s3, s2-prices[i]);
        //     s4 = Math.max(s4, s3+prices[i]);
        // }
        // return s4;
        int n = prices.length;
        int left[] = new int[n];
        int right[] = new int[n];
        int minLeft = prices[0];
        int maxRight = prices[n-1];
        for(int i=1; i<n; i++) {
            left[i] = Math.max(left[i-1], prices[i]-minLeft);
            minLeft = Math.min(minLeft, prices[i]);
        }
        for(int i=n-2; i>=0; i--) {
            right[i] = Math.max(right[i+1], maxRight-prices[i]);
            maxRight = Math.max(maxRight, prices[i]);
        }
        int maxProfit = 0;
        for(int i=0; i<n; i++) {
            maxProfit = Math.max(maxProfit, left[i] + right[i]);
        }
        return maxProfit;
    }
}