class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char iChar = Character.toLowerCase(s.charAt(i));
            char jChar = Character.toLowerCase(s.charAt(j));
            if (!Character.isLetterOrDigit(iChar)) {
                i++;
            } else if (!Character.isLetterOrDigit(jChar)) {
                j--;
            } else {
                if (iChar != jChar) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}
