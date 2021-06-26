// 10
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean T[][] = new boolean[m+1][n+1];
        T[0][0] = true;
        // for(int i=1; i<=m; i++) {
        //     T[i][0] = false;
        // }
        for(int j=1; j<=n; j++) {
            if(p.charAt(j-1) == '*')
                T[0][j] = T[0][j-2];
            // else
            //     T[0][j] = false;
        }
        
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                    T[i][j] = T[i-1][j-1];
                }
                else if(p.charAt(j-1) == '*') {
                    T[i][j] = T[i][j-2];
                    if(s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') {
                        T[i][j] = T[i][j] || T[i-1][j];
                    }
                }
                // else {
                //     T[i][j] = false;
                // }
            }
        }
        
        return T[m][n];
    }
}