/*
Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

Example 1:

Input: s = "1 + 1"
Output: 2
Example 2:

Input: s = " 2-1 + 2 "
Output: 3
Example 3:

Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23
*/

class Solution {
    public int calculate(final String s) {
        Stack<Integer> stack = new Stack<>();

        int sign = 1;
        int number = 0;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    number = number * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                number = number * sign;
                result += number;
                number = 0;
                sign = 1;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if (c == ')') {
                int prevSign = stack.pop();
                result = prevSign * result;
                int prevRes = stack.pop();
                result = prevRes + result;
            }
        }

        return result;
    }
}
