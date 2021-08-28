/*
Given an array of strings strs, return the length of the longest uncommon subsequence between them. If the longest uncommon subsequence does not exist, return -1.

An uncommon subsequence between an array of strings is a string that is a subsequence of one string but not the others.

A subsequence of a string s is a string that can be obtained after deleting any number of characters from s.
*/

class Solution {
    public int findLUSlength(String[] strs) {
        int max = -1;
        for(int i = 0; i < strs.length; i++) {
            String s = strs[i];
            if(s.length() > max) {
                boolean flag = false;
                for(int j = 0; j < strs.length; j++) {
                    if(i != j && isSubsequence(s, strs[j])) {
                        flag = true;
                        break;
                    }
                }
                if(!flag) {
                    max = s.length();
                }
            }
        }
        return max;
    }
    
    private boolean isSubsequence(String s, String t) {
        if(s.equals(t)) {
            return true;
        }
        if(s.length() > t.length()) {
            return false;
        }
        int i = 0;
        int j = 0;
        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) == t.charAt(j++)) {
                i++;
            }
        }
        return i == s.length();
    }
}