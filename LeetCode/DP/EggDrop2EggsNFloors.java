/*

You are given two identical eggs and you have access to a building with n floors labeled from 1 to n.

You know that there exists a floor f where 0 <= f <= n such that any egg dropped at a floor higher than f will break, and any egg dropped at
or below floor f will not break.

In each move, you may take an unbroken egg and drop it from any floor x (where 1 <= x <= n). If the egg breaks, you can no longer use it.
However, if the egg does not break, you may reuse it in future moves.

Return the minimum number of moves that you need to determine with certainty what the value of f is.

*/

class Solution {
    public int twoEggDrop(int n) {
        int k = 2;
        if(n==1 || n==0 || k==1) {
            return n;
        }

        int t[][] = new int[k + 1][n + 1];
        for(int i = 1; i <= k; i++) {
            t[i][1] = 1;
            t[i][0] = 0;
        }

        for(int j = 1; j <= n; j++) {
            t[1][j] = j;
        }

        for(int i = 2; i <= k; i++) {
            for(int j = 2; j <= n; j++) {
                t[i][j] = Integer.MAX_VALUE;
                for(int x = 1; x <= j; x++) {
                    int res = 1 + Math.max(t[i-1][x-1], t[i][j-x]);
                    if(res < t[i][j]) {
                        t[i][j] = res;
                    }
                }
            }
        }

        return t[k][n];
    }
}