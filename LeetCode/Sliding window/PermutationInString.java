/*
Given two strings s1 and s2, return true if s2 contains the permutation of s1.

In other words, one of s1's permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false

Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.

*/
class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // below solution does not work if s2 contains duplicate characters of s1
        // List<Integer> indices = new ArrayList<>();
        // for(int i = 0; i < s1.length(); i++) {
        //     String s = s1.substring(i, i+1);
        //     int index = s2.indexOf(s);
        //     if(index == -1) {
        //         return false;
        //     }
        //     indices.add(index);
        // }
        // Collections.sort(indices);
        // for(int i = 1; i < indices.size(); i++) {
        //     if(indices.get(i) != indices.get(i-1) + 1) {
        //         return false;
        //     }
        // }
        // return true;
        
         // Sliding window
        if(s1.length() > s2.length()) {
            return false;
        }
        int s1map[] = new int[26];
        int s2map[] = new int[26];
        
        for(int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < s2.length() - s1.length(); i++) {
            if(match(s1map, s2map)) {
                return true;
            }
            s2map[s2.charAt(i) - 'a']--;
            s2map[s2.charAt(i + s1.length()) - 'a']++;
        }
        return match(s1map, s2map);
        
    }
    
    private boolean match(int s1[], int s2[]) {
        for(int i = 0; i < s1.length; i++) {
            if(s1[i] != s2[i]) {
                return false;
            }
        }
        return true;
    }
    
   
}