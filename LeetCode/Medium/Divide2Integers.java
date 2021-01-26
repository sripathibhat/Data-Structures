// 29
class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend<0 && divisor<0)
            return dividend/divisor == Integer.MIN_VALUE ? Integer.MAX_VALUE : dividend/divisor;
        else {
            return dividend/divisor;
        }
    }
}