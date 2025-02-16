/**

Given two strings s and part, perform the following operation on s until all occurrences of the substring part are removed:

Find the leftmost occurrence of the substring part and remove it from s.
Return s after removing all occurrences of part.

A substring is a contiguous sequence of characters in a string.


Example 1:

Input: s = "daabcbaabcbc", part = "abc"
Output: "dab"
Explanation: The following operations are done:
- s = "daabcbaabcbc", remove "abc" starting at index 2, so s = "dabaabcbc".
- s = "dabaabcbc", remove "abc" starting at index 4, so s = "dababc".
- s = "dababc", remove "abc" starting at index 3, so s = "dab".
Now s has no occurrences of "abc".
Example 2:

Input: s = "axxxxyyyyb", part = "xy"
Output: "ab"
Explanation: The following operations are done:
- s = "axxxxyyyyb", remove "xy" starting at index 4 so s = "axxxyyyb".
- s = "axxxyyyb", remove "xy" starting at index 3 so s = "axxyyb".
- s = "axxyyb", remove "xy" starting at index 2 so s = "axyb".
- s = "axyb", remove "xy" starting at index 1 so s = "ab".
Now s has no occurrences of "xy".

*/

class Solution {
    public String removeOccurrences(String s, String part) {
        // int index = s.indexOf(part);
        // while (index > -1) {
        //     s = s.substring(0, index) + s.substring(index + part.length());
        //     index = s.indexOf(part);
        // }
        // return s;

        Stack<Character> stack = new Stack();
        int slen = s.length();
        int plen = part.length();
        for (int i = 0; i < slen; i++) {
            stack.push(s.charAt(i));
            if (stack.size() >= plen && checkMatch(stack, part, plen)) {
                for (int j = 0; j < plen; j++) {
                    stack.pop();
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        res.reverse();
        return res.toString();
    }
    
    private boolean checkMatch(Stack<Character> stack, String part, int plen) {
        Stack<Character> temp = new Stack<>();
        temp.addAll(stack);
        for (int partIndex = plen - 1; partIndex >= 0; partIndex--) {
            if (temp.isEmpty() || temp.peek() != part.charAt(partIndex)) {
                return false;
            }
            temp.pop();
        }
        return true;
    }
}
