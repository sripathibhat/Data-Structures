/**


Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

 

Example 1:

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
Example 2:

Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".
Example 3:

Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".
 

*/

class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        for (char ch: s.toCharArray()) {
            if (ch == '#' && !s1.isEmpty()) {
                s1.pop();
            } else if (ch != '#') {
                s1.push(ch);
            }
        }
        for (char ch: t.toCharArray()) {
            if (ch == '#' && !s2.isEmpty()) {
                s2.pop();
            } else if (ch != '#') {
                s2.push(ch);
            }
        }

        if (s1.size() != s2.size()) {
            return false;
        }
        while (!s1.isEmpty() && s1.peek() == s2.peek()) {
            s1.pop();
            s2.pop();
        }
        return s1.isEmpty();
    }
}
