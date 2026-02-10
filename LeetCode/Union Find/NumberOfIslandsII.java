/**
  
You are given an empty 2D binary grid grid of size m x n. The grid represents a map where 0's represent water and 1's represent land. 
Initially, all the cells of grid are water cells (i.e., all the cells are 0's).

We may perform an add land operation which turns the water at position into a land. You are given an array positions where 
positions[i] = [rᵢ, cᵢ] is the position (rᵢ, cᵢ) at which we should operate the ith operation.

Return an array of integers answer where answer[i] is the number of islands after turning the cell (rᵢ, cᵢ) into a land.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges
of the grid are all surrounded by water.

Example 1:

Input: m = 3, n = 3, positions = [[0,0],[0,1],[1,2],[2,1]]

Output: [1,1,2,3]
Explanation:
Initially, the 2d grid is filled with water.

Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land. We have 1 island.
Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land. We still have 1 island.
Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land. We have 2 islands.
Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land. We have 3 islands.
Example 2:

Input: m = 1, n = 1, positions = [[0,0]]

Output: [1]

Constraints:

1 <= m, n, positions.length <= 10⁴
1 <= m * n <= 10⁴
positions[i].length == 2
0 <= rᵢ < m
0 <= cᵢ < n

Follow up: Could you solve it in time complexity O(k log(mn)), where k == positions.length?

*/

class Solution {
    boolean isValid(int i, int j, int m, int n, int vis[][]) {
        return i >= 0 && i < m && j >= 0 && j < n && vis[i][j] == 1;
    }
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList();
        int vis[][] = new int[m][n];
        int cnt = 0;
        DisjointSet dsu = new DisjointSet(m * n);
        for (int pos[]: positions) {
            int x = pos[0];
            int y = pos[1];
            if (vis[x][y] == 1) {
                res.add(cnt);
                continue;
            }
            vis[x][y] = 1;
            cnt++;
            int dirs[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int i = 0; i < dirs.length; i++) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];
                if (isValid(nx, ny, m, n, vis)) {
                    int curNode = n * x + y;
                    int adjNode = n * nx + ny;
                    if (dsu.findUltimatePar(curNode) != dsu.findUltimatePar(adjNode)) {
                        cnt--;
                        dsu.unionBySize(curNode, adjNode);
                    }
                }
            }
            res.add(cnt);
        }
        return res;
    }

    class DisjointSet {
        private int par[];
        private int size[];

        public DisjointSet(int n) {
            par = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                par[i] = i;
                size[i] = 1;
            }
        }

        public int findUltimatePar(int i) {
            if (par[i] == i) {
                return i;
            }
            return par[i] = findUltimatePar(par[i]);
        }

        public void unionBySize(int u, int v) {
            int paru = findUltimatePar(u);
            int parv = findUltimatePar(v);
            if (paru == parv) {
                return;
            }
            if (size[paru] < size[parv]) {
                par[paru] = parv;
                size[parv] += size[paru];
            } else {
                par[parv] = paru;
                size[paru] += size[parv];
            }
        }
    }
}



