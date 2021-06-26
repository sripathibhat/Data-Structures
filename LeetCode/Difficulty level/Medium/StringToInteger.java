// 8
class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.equals("") || (!isDigit(s.charAt(0)) && s.charAt(0) != '-' && s.charAt(0) != '+')) {
            return 0;
        }
        String res = "";
        for(int i=0; i<s.length(); i++) {
            if(isDigit(s.charAt(i)) || (i == 0 && (s.charAt(i) == '-' || s.charAt(i) == '+'))) {
                res = res + s.charAt(i);
            } else {
                break;
            }
        }
        if(res.equals("+") || res.equals("-")) 
            return 0;
        try {
            return Integer.valueOf(res);
        } catch (NumberFormatException e) {
            return res.charAt(0) != '-' ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
    }
    
    private boolean isDigit(char c) {
        return (c >= '0' && c <= '9');
    }
}