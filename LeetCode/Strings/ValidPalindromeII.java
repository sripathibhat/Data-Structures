/**

Given a string s, return true if the s can be palindrome after deleting at most one character from it. 

Example 1:

Input: s = "aba"
Output: true
Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
Example 3:

Input: s = "abc"
Output: false

*/

class Solution {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        int cnt = 0;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalin(s, i + 1, j) || isPalin(s, i, j - 1);
            }
            i++;
            j--;
        }
        return cnt <= 1;
    }

    private boolean isPalin(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
