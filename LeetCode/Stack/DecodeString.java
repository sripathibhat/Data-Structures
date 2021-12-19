/*

Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets
is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are
well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are
only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

*/

class Solution {
    public String decodeString(String s) {
        Stack<Integer> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();
        
        String res = "";
        int i = 0;
        while(i < s.length()) {
            if(Character.isDigit(s.charAt(i))) {
                int num = 0;
                while(Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                s1.push(num);
            }
            else if(s.charAt(i) == '[') {
                s2.push(res);
                i++;
                res = "";
            }
            else if(s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder(s2.pop());
                int cnt = s1.pop();
                for(int j = 0; j < cnt; j++) {
                    sb.append(res);
                }
                res = sb.toString();
                i++;
            }
            else {
                res += s.charAt(i);
                i++;
            }
        }
        return res;
    }
}