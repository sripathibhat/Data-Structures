/*

    Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.

    Return the maximum possible length of s.

*/

class Solution {
    
    // Reference - coding decoded
    public int maxLength(List<String> arr) {
        List<String> res = new ArrayList<>();
        res.add("");
        int max = 0;
        for(String s: arr) {
            List<String> cn = new ArrayList<>();
            for(String r: res) {
                String concat = s + r;
                if(unique(concat)) {
                    cn.add(concat);
                    max = Math.max(max, concat.length());
                }
            }
            res.addAll(cn);
        }
        return max;
    }
    
    private boolean unique(String s) {
        int cnt[] = new int[26];
        for(char ch: s.toCharArray()) {
            if(cnt[ch - 'a'] == 1) {
                return false;
            }
            cnt[ch - 'a']++;
        }
        return true;
    }
}