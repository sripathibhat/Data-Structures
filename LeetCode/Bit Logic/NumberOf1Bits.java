public class Solution {
    // you need to treat n as an unsigned value
    int cnt = 0;
    public int hammingWeight(int n) {
        for(int i=0; i<32; i++) {
            if((n & (1<<i)) != 0) {
                cnt++;
            }
        }
        return cnt;
    }
}