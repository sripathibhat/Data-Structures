/*

Given a string s, return the longest 
palindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"

*/

class Solution {
    int start, len;
    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            // consider each index as mid of palindrome and expand out
            // even length palindrome
            solve(s, i, i + 1);
            // odd length palindrome
            solve(s, i, i);
        }
        return s.substring(start, start + len);
    }
    
    private void solve(String s, int l, int h) {
        while (l >= 0 && h < s.length() && s.charAt(l) == s.charAt(h)) {   
            if (len < h - l + 1) {
                len = h - l + 1;
                start = l;
            }
            l--;
            h++; 
        }
    }
}
