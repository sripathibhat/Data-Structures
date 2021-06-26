// 301
class Solution {
    int min = Integer.MAX_VALUE;
    Set<String> res = new HashSet();
    public List<String> removeInvalidParentheses(String s) {
        helper(s, 0, 0, 0, new StringBuilder(), 0);
        return new ArrayList(res);
    }
    
    private void helper(String s, int index, int leftCnt, int rightCnt, StringBuilder expr, int removedCnt) {
        
        if(index == s.length()) {
            // entire string processed
            if(leftCnt == rightCnt) {
                // possible answer
                if(removedCnt <= min) {
                    String possibleAns = expr.toString();
                    if(removedCnt < min) {
                        res.clear();
                        min = removedCnt;
                    }
                    res.add(possibleAns);
                }
            }
        }
        
        else {
            char curChar = s.charAt(index);
            int len = expr.length();
            
            if(curChar != '(' && curChar != ')') {
                expr.append(curChar);
                helper(s, index+1, leftCnt, rightCnt, expr, removedCnt);
                expr.deleteCharAt(len);
            }
            else {
                // delete current char and move on
                helper(s, index+1, leftCnt, rightCnt, expr, removedCnt+1);
                expr.append(curChar);
                
                if(curChar == '(') {
                    helper(s, index+1, leftCnt+1, rightCnt, expr, removedCnt);
                }
                else if(rightCnt < leftCnt) {
                    helper(s, index+1, leftCnt, rightCnt+1, expr, removedCnt);
                }
                expr.deleteCharAt(len);
            }
        }
    }
}