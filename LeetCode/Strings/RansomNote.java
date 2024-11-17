class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // int cnt1[] = new int[128];
        // int cnt2[] = new int[128];
        // for (char c: magazine.toCharArray())
        //     cnt1[c]++;
        // for (char c: ransomNote.toCharArray())
        //     cnt2[c]++;
        // for(char c: ransomNote.toCharArray()) {
        //     if (cnt2[c] > cnt1[c])
        //         return false;
        // }
        // return true;


        // Using single count array
        int cnt[] = new int[128];
        for (char ch: magazine.toCharArray()) {
            cnt[ch]++;
        }
        for (char ch: ransomNote.toCharArray()) {
            cnt[ch]--;
            if (cnt[ch] < 0) {
                return false;
            }
        }
        return true;
    }
}
