// 5
class Solution {
    int start, len;
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n<=1) {
            return s;
        }
        for(int i=0;i<n;i++) {
            expand(s, i, i);
            expand(s, i, i+1);
        }
        return s.substring(start, start+len);
    }
    
    private void expand(String s, int begin, int end) {
        if(begin > end) {
            return;
        }
        while(begin>=0 && end<s.length() && s.charAt(begin) == s.charAt(end)) {
            begin--; 
            end++;
        }
        if(len < end-begin-1) {
            len = end-begin-1;
            start = begin+1;
        }
    }
}