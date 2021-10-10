/*

    Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.

*/

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        // common prefix between left and right is the answer
        // e.g 12 and 15 -> 12
        // 1100 1111 - common prefix - 1100
        int res = 0;
        for(int i = 31; i >=0; i--) {
            int leftBit = left & (1 << i);
            int rightBit = right & (1 << i);
            if(leftBit == rightBit) {
                res |= leftBit;
            } else {
                break;
            }
        }
        return res;
    }
}