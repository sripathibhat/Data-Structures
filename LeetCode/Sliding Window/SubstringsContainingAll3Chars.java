/**

Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 
Example 3:

Input: s = "abc"
Output: 1

*/

class Solution {
    public int numberOfSubstrings(String s) {
        int len = s.length();
        int i = 0, j = 0;
        int freq[] = new int[3];
        int total = 0;
        while (j < len) {
            char cur = s.charAt(j);
            freq[cur - 'a']++;
            while (hasAllChars(freq)) {
                total += len - j;
                char leftChar = s.charAt(i);
                freq[leftChar - 'a']--;
                i++;
            }
            j++;
        }
        return total;
    }
    
    private boolean hasAllChars(int freq[]) {
        return freq[0] > 0 && freq[1] > 0 && freq[2] > 0;
    }
}
