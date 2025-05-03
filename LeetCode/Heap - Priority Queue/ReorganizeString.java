/**

Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

Return any possible rearrangement of s or return "" if not possible.

Example 1:

Input: s = "aab"
Output: "aba"


Example 2:

Input: s = "aaab"
Output: ""

*/

class Solution {
    public String reorganizeString(String s) {
        int freq[] = new int[26];
        for (char ch: s.toCharArray()) {
            freq[ch - 'a']++;
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> freq[b - 'a'] - freq[a - 'a']);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.add((char)(i + 'a'));
            }
        }
        StringBuilder sb = new StringBuilder();

        while (pq.size() >= 2) {
            char first = pq.poll();
            char sec = pq.poll();
            sb.append(first);
            sb.append(sec);
            freq[first - 'a'] = freq[first - 'a'] - 1;
            freq[sec - 'a'] = freq[sec - 'a'] - 1;
            if (freq[first - 'a'] > 0) {
                pq.add(first);
            }
            if (freq[sec - 'a'] > 0) {
                pq.add(sec);
            }
        }

        if (!pq.isEmpty()) {
            char last = pq.poll();
            if (freq[last - 'a'] > 1) {
                return "";
            }
            sb.append(last);
        }

        return sb.toString();
    }
}
