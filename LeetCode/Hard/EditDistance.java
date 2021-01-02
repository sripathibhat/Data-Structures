// 72
class Solution {
    public int minDistance(String word1, String word2) {
        // DP
        int m = word1.length();
        int n = word2.length();
        int T[][] = new int[2][n+1];
        for (int i=0;i<=m;i++) {
            for(int j=0;j<=n;j++) {
                if(i==0) T[i%2][j] = j;
                else if(j==0) T[i%2][j] = i;
                else if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    T[i%2][j] = T[(i-1)%2][j-1];
                } else {
                    T[i%2][j] = 1 + Math.min(Math.min(T[i%2][j-1], T[(i-1)%2][j]), T[(i-1)%2][j-1]);
                }
            }
        }
        return T[m%2][n];
        // return solve(m,n,word1,word2);
    }
    
    // Recursion - time limit exceeded
    private int solve(int m, int n, String s1, String s2) {
        if (m==0) return n;
        if (n==0) return m;
        if (s1.charAt(m-1) == s2.charAt(n-1)) {
            return solve(m-1,n-1,s1,s2);
        }
        return 1+ Math.min(Math.min(solve(m,n-1,s1,s2), solve(m-1,n,s1,s2)), solve(m-1,n-1,s1,s2));
    }
}