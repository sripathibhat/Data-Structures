class Solution {
    public int longestPalindrome(String s) {
        int freq[] = new int[52];
        for (char ch: s.toCharArray()) {
            if (ch <= 'Z' && ch >= 'A') {
                freq[ch - 'A']++;
            } else {
                freq[ch - 'a' + 26]++;
            }
        }
        boolean oddFound = false;
        int evenLen = 0;
        for (int i = 0; i < 52; i++) {
            if (freq[i] % 2 == 0) {
                evenLen += freq[i];
            } else {
                evenLen += freq[i] - 1;
                oddFound = true;
            }
        }
        return oddFound ? evenLen + 1 : evenLen;

    }
}
