class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack();
        for(int i=0; i<tokens.length; i++) {
            String ch = tokens[i];
            if(isOperator(ch)) {
                int op2 = st.pop();
                int op1 = st.pop();
                switch(ch) {
                    case "+" : st.push(op1 + op2); break;
                    case "-" : st.push(op1 - op2); break;
                    case "*" : st.push(op1 * op2); break;
                    case "/" : st.push(op1 / op2); break;
                }
            }
            else {
                st.push(Integer.parseInt(ch));
            }
        }
        return st.pop();
    }
    
    private boolean isOperator(String ch) {
        return ch.equals("/") || ch.equals("*") || ch.equals("+") || ch.equals("-");
    }
}