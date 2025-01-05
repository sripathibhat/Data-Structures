/*

Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses 
substring

Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:

Input: s = ""
Output: 0

*/

class Solution {
    public int longestValidParentheses(String s) {
        int res = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && st.peek() != -1 && s.charAt(st.peek()) == '(') {
                st.pop();
                res = Math.max(res, i - st.peek());
            } else {
                st.push(i);
            }
        }
        return res;
    }
}
