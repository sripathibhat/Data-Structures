/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

*/

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> l = new ArrayList<String>();
        String mapping[] = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if (digits == null || digits.length() == 0) {
            return l;
        }
        helper(l, digits, "", 0, mapping);
        return l;
    }

    private void helper(List<String> l, String digits, String cur, int index, String[] m) {
        if (cur.length() == digits.length()) {
            l.add(cur);
            return;
        }
        String letters = m[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            // String newcur = cur+letters.charAt(i);
            helper(l, digits, cur + letters.charAt(i), index + 1, m);
        }
    }
}
