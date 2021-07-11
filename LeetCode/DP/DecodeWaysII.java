class Solution {
    public int numDecodings(String s) {
        int MOD = 1000000007;
        long dp[] = new long[s.length() + 1];
        dp[0] = 1;
        dp[1] = decodeOneChar(s.charAt(0));
        
        for(int i = 2; i <= s.length(); i++) {
            char prevChar = s.charAt(i-2);
            char curChar = s.charAt(i-1);
            dp[i] += dp[i-1] * decodeOneChar(curChar);
            dp[i] += dp[i-2] * decodeTwoChar(curChar, prevChar);
            dp[i] = dp[i] % MOD;
        }
        return (int) dp[s.length()];
    }
    
    // Reference - Coding decoded https://github.com/Sunchit/Coding-Decoded/blob/master/July2021/DecodeWaysII.java
    
    private int decodeOneChar(char ch) {
        if(ch == '*') {
            return 9;
        }
        return ch == '0' ? 0 : 1;
    }
    
    private int decodeTwoChar(char curChar, char prevChar) {
        switch(prevChar) {
            case '*' : 
                if(curChar == '*') {
                    return 15;
                }
                return curChar <= '6' ? 2 : 1;
            case '1' :
                return curChar == '*' ? 9 : 1;
            case '2' :
                if(curChar == '*') {
                    return 6;
                }
                return curChar <= '6' ? 1 : 0;
        }
        return 0;
    }
}