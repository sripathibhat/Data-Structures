/**
You are given a string word and a non-negative integer k.

Return the total number of substrings of word that contain every vowel ('a', 'e', 'i', 'o', and 'u') at least once and exactly k consonants.

Example 1:

Input: word = "aeioqq", k = 1

Output: 0

Explanation:

There is no substring with every vowel.

Example 2:

Input: word = "aeiou", k = 0

Output: 1

Explanation:

The only substring with every vowel and zero consonants is word[0..4], which is "aeiou".

Example 3:

Input: word = "ieaouqqieaouqq", k = 1

Output: 3

Explanation:

The substrings with every vowel and one consonant are:

word[0..5], which is "ieaouq".
word[6..11], which is "qieaou".
word[7..12], which is "ieaouq".
 
*/

class Solution {
    public long countOfSubstrings(String word, int k) {
        return atLeastK(word, k) - atLeastK(word, k + 1);
    }

    private long atLeastK(String word, int k) {
        long validSubstrings = 0;
        int i = 0, j = 0;
        Map<Character, Integer> vowelCount = new HashMap<>();
        int nonVowelCount = 0;
        while (j < word.length()) {
            char letter = word.charAt(j);
            if (isVowel(letter)) {
                vowelCount.put(letter, vowelCount.getOrDefault(letter, 0) + 1);
            } else {
                nonVowelCount++;
            }

            while (vowelCount.size() == 5 && nonVowelCount >= k) {
                validSubstrings += word.length() - j;
                char left = word.charAt(i);
                if (isVowel(left)) {
                    vowelCount.put(left, vowelCount.get(left) - 1);
                    if (vowelCount.get(left) == 0) {
                        vowelCount.remove(left);
                    }
                } else {
                    nonVowelCount--;
                }
                i++;
            }
            j++;
        }
        return validSubstrings;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
