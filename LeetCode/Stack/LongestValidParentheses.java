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

        // Extra space
        // Stack<Integer> st = new Stack<>();
        // st.push(-1);
        // for (int i = 0; i < s.length(); i++) {
        //     if (s.charAt(i) == ')' && st.peek() != -1 && s.charAt(st.peek()) == '(') {
        //         st.pop();
        //         res = Math.max(res, i - st.peek());
        //     } else {
        //         st.push(i);
        //     }
        // }

        // Optimized - No extra space
        int left_count = 0;
        int right_count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left_count++;
            } else {
                right_count++;
            }
            if (left_count == right_count) {
                res = Math.max(res, left_count + right_count);
            } else if (left_count < right_count) {
                left_count = right_count = 0;
            }
        }

        left_count = right_count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left_count++;
            } else {
                right_count++;
            }
            if (left_count == right_count) {
                res = Math.max(res, left_count + right_count);
            } else if (left_count > right_count) {
                left_count = right_count = 0;
            }
        }


        return res;
    }
}

