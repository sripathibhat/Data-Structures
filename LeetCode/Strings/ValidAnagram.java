class Solution {
    public boolean isAnagram(String s, String t) {
        // char c1[] = new char[26];
        // char c2[] = new char[26];
        // for(char ch: s.toCharArray()) {
        //     c1[ch-'a']++;
        // }
        // for(char ch: t.toCharArray()) {
        //     c2[ch-'a']++;
        // }
        // for(int i=0;i<26;i++) {
        //     if(c1[i] != c2[i]) {
        //         return false;
        //     }
        // }
        // return true;
        
        // using 1 count array
        int cnt[] = new int[26];
        for (char ch: s.toCharArray()) {
            cnt[ch - 'a']++;
        }
        for (char ch: t.toCharArray()) {
            cnt[ch - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
