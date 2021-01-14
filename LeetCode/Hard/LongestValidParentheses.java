// 32
class Solution {
    public int longestValidParentheses(String s) {
        int res = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == ')' && st.peek() != -1 && s.charAt(st.peek()) == '(') {
                st.pop();
                res = Math.max(res, i-st.peek());
            } else {
                st.push(i);
            }
        }
        // System.out.println(st.size() + " " + " " + st.pop());
        return res;
    }
}