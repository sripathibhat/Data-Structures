class Solution {
    public String minWindow(String s, String t) {
        int startIndex = -1, minLen = Integer.MAX_VALUE, i = 0, j = 0;
        int len1, len2, cnt = 0;
        len1 = s.length();
        len2 = t.length();
        if(len1 < len2) {
            return "";
        }
        int hasht[] = new int[128];
        int hashs[] = new int[128];
        while(j < len2) {
            hasht[t.charAt(j++)]++;
        }
        j = 0;
        // System.out.println(len1 + " " + len2);
        while(j < len1) {
            hashs[s.charAt(j)]++;
            if(hasht[s.charAt(j)] != 0 && hashs[s.charAt(j)] <= hasht[s.charAt(j)]) {
                cnt++; //matching character of t found in s
            }
            if(cnt == len2) {
                // System.out.println("j=" +j);
                // found all chars of t, try reducing length of s containing t
                while((hashs[s.charAt(i)] > hasht[s.charAt(i)]) || hasht[s.charAt(i)] == 0) {
                    if(hashs[s.charAt(i)] > hasht[s.charAt(i)]) {
                        hashs[s.charAt(i)]--;
                    }
                    i++;
                }
                int winLen = j - i + 1; // current window length
                if(minLen > winLen) {
                    minLen = winLen;
                    startIndex = i;
                }
            }
            j++;
        }
        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLen);
    }
}