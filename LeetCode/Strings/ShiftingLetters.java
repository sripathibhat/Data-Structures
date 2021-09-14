/*

    You are given a string s of lowercase English letters and an integer array shifts of the same length.

    Call the shift() of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a').

    For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.
    Now for each shifts[i] = x, we want to shift the first i + 1 letters of s, x times.

    Return the final string after all such shifts to s are applied.

*/

class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        char c[] = s.toCharArray();
        int shift = 0;
        char res[] = new char[c.length];
        for(int i = s.length() - 1; i >= 0; i--) {
            shift += shifts[i] % 26;
            res[i] = (char)((c[i] - 'a' + shift) % 26 + 'a');
        }
        return new String(res);
    }
}