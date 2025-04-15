/**

Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.

Please implement encode and decode

Example 1:

Input: ["neet","code","love","you"]

Output:["neet","code","love","you"]
Example 2:

Input: ["we","say",":","yes"]

Output: ["we","say",":","yes"]

*/

class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String s: strs) {
            int cnt = s.length();
            encoded.append(cnt + "#" + s);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int cnt = 0;
            char ch = str.charAt(i);
            while (ch != '#') {
                cnt = cnt * 10 + ch - '0';
                i++;
                ch = str.charAt(i);
            }
            i++; // skip '#'' character
            StringBuilder sb = new StringBuilder();
            sb.append(str.substring(i, i + cnt)); 
            res.add(sb.toString());
            i += cnt;
        }
        return res;
    }
}
