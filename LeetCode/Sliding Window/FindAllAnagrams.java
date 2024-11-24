/*
Given two strings s and p, return an array of all the start indices of p's 
anagrams in s. You may return the answer in any order.

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".


Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int k = p.length();
        // sliding window approach
        HashMap<Character, Integer> map = new HashMap();
        List<Integer> res = new ArrayList();
        int cnt = 0;
        for (char ch: p.toCharArray()) {
            int x = map.getOrDefault(ch, 0);
            map.put(ch, ++x);
            if (x == 1) {
                cnt++;
            }
        }
        int j = 0, i = 0;
        while (j < s.length()) {
            if (map.containsKey(s.charAt(j))) {
                int x = map.get(s.charAt(j));
                map.put(s.charAt(j), --x);
                if (x == 0) {
                    cnt--;
                }
            }
 
            if (j - i + 1 == k) {
                if (cnt == 0) {
                    // all characters of pattern found in current window, increment ans
                    res.add(i);
                }
                if (map.containsKey(s.charAt(i))) {
                    int x = map.get(s.charAt(i));
                    map.put(s.charAt(i), ++x);
                    if (x == 1) {
                        cnt++;
                    }
                }   
                i++;
            }
            j++;
        }    
        return res;

        // 2 map approach with sliding window

        // List<Integer> res = new ArrayList<>();
        // if (p.length() > s.length()) {
        //     return res;
        // }
        // Map<Character, Integer> pMap = new HashMap<>();
        // Map<Character, Integer> sMap = new HashMap<>();
        // for (int i = 0; i < p.length(); i++) {
        //     pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
        //     sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        // }
        // if (pMap.equals(sMap)) {
        //     res.add(0);
        // }
        // int l = 0, r = p.length();
        // while (r < s.length()) {
        //     sMap.put(s.charAt(r), sMap.getOrDefault(s.charAt(r), 0) + 1);
        //     sMap.put(s.charAt(l), sMap.getOrDefault(s.charAt(l), 0) - 1);
        //     if (sMap.get(s.charAt(l)) <= 0) {
        //         sMap.remove(s.charAt(l));
        //     }
        //     l++;
        //     r++;
        //     if (sMap.equals(pMap)) {
        //         System.out.println(pMap + " " + sMap);
        //         res.add(l);
        //     }
        // }
        // return res;
    }
}
