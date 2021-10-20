/*

    Given an input string s, reverse the order of the words.

    A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

    Return a string of the words in reverse order concatenated by a single space.

    Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have
    a single space separating the words. Do not include any extra spaces.

*/

class Solution {
    public String reverseWords(String s) {
        int i = 0;
        s = s.trim();
        
        while(i < s.length()) {
            int j = i + 1;
            while(j < s.length() && s.charAt(j) != ' ') {
                j++;
            }
            s = reverse(s, i, j);
            i = j + 1;
            while(i < s.length() && s.charAt(i) == ' ') {
                i++;
            }     
        }
        s = reverse(s, 0, s.length());
        StringBuilder sb = new StringBuilder();
        i = 0;
        while(i < s.length()) {
            char ch = s.charAt(i);
            if(ch != ' ') {
                sb.append(ch);
            }
            else if(ch == ' ') {
                if(s.charAt(i - 1) != ' ') {
                    sb.append(ch);
                }
            }
            i++;
        }
        s = sb.toString();
        return s;
    }
    
    private String reverse(String s, int i, int j) {
        char ch[] = s.toCharArray();
        int l = i, h = j - 1;
        while(l < h) {
            char t = ch[l];
            ch[l] = ch[h];
            ch[h] = t;
            l++;
            h--;
        }
        return new String(ch);
    }
}