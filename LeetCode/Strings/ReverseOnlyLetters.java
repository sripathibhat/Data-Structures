/*

    Given a string s, reverse the string according to the following rules:

    All the characters that are not English letters remain in the same position.
    All the English letters (lowercase or uppercase) should be reversed.
    Return s after reversing it.

*/

class Solution {
    public String reverseOnlyLetters(String s) {
        int i = 0;
        int j = s.length() - 1;

        while(i < s.length() && !isLetter(s.charAt(i))) {
            i++;
        }

        while(j >= 0 && !isLetter(s.charAt(j))) {
            j--;
        }

        char arr[] = s.toCharArray();
        while(i < j) {
            while(!isLetter(s.charAt(i))) i++;
            while(!isLetter(s.charAt(j))) j--;
            if(i >= j) {
                break;
            }
            char ch = arr[i];
            arr[i] = arr[j];
            arr[j] = ch;
            i++;
            j--;
        }

        return new String(arr);
    }
    
    private boolean isLetter(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }
}