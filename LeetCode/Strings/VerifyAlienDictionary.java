/**

In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographically in this alien language.
 

Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.

Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.

Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", 
because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).

*/

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderMap = new int[26];
        for (int i = 0; i < order.length(); i++){
            orderMap[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            for (int j = 0; j < w1.length(); j++) {
                // If we do not find a mismatch letter between words[i] and words[i + 1],
                // we need to examine the case when words are like ("apple", "app").
                if (j == w2.length()) {
                    return false;
                }
                if (w1.charAt(j) != w2.charAt(j)) {
                    int currentWordChar = w1.charAt(j) - 'a';
                    int nextWordChar = w2.charAt(j) - 'a';

                    if (orderMap[currentWordChar] > orderMap[nextWordChar]) {
                        return false;
                    }
                    // if we find the first different letter and they are sorted,
                    // then there's no need to check remaining letters
                    break;
                }
            }
        }

        return true;
    }
}
