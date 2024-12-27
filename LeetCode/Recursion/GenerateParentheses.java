/*

    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

*/

class Solution {
    public List<String> generateParenthesis(int n) {
        // backtracking
        List<String> res = new ArrayList<>();
        solve(0, 0, "", res, n);
        return res;
    }
    
    private void solve(int o, int c, String cur, List<String> list, int n) {
        if(o == n && c == n) {
            list.add(cur);
            return;
        }
        // When number of open brackets == number of closed brackets, we have to choose open bracket
        if(o == c) {
            solve(o + 1, c, cur + "(", list, n);
            return;
        }
        // When # of ) > # of (, we have 2 choices - Choose open bracket or choose closed bracket, both are valid combinations
        if(o > c && o <= n) {
            solve(o + 1, c, cur + "(", list, n);
            solve(o, c + 1, cur + ")", list, n);
        }
    }
}
