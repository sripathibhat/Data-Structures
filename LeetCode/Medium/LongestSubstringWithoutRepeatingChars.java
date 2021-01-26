// 3
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0,j=0,max=0;
        HashSet<Character> h=new HashSet<>();
        while(j<s.length()) {
            if(!h.contains(s.charAt(j))) {
                h.add(s.charAt(j));
                j++;
                max = Math.max(h.size(), max);
            } else {
                h.remove(s.charAt(i));
                i++;
            }
        }
        return max;
        // int max=Integer.MIN_VALUE;
        // int T[][] = new int[s.length()+1][s.length()+1];
        // for(int i=0;i<=s.length();i++) {
        //     for(int j=0;j<=s.length(); j++)
        //     {
        //         if(i==0 || j==0) {
        //             T[i][j] = 0;
        //         }
        //         else if(s.charAt(i-1) != s.charAt(j-1)) {
        //             T[i][j] = 1+T[i-1][j-1];
        //             max = Math.max(T[i][j], max);
        //         } else {
        //             T[i][j] = 0;
        //         }
        //     }
        // }
        // return max;
    }
}