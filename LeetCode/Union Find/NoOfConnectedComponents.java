/**

There is an undirected graph with n nodes. There is also an edges array, where edges[i] = [a, b] means that there is an edge between node a and node b in the graph.

The nodes are numbered from 0 to n - 1.

Return the total number of connected components in that graph.

Example 1:

Input:
n=3
edges=[[0,1], [0,2]]

Output:
1
Example 2:

Input:
n=6
edges=[[0,1], [1,2], [2,3], [4,5]]

Output:
2

*/

class Solution {

    public int countComponents(int n, int[][] edges) {
        int res = n;
        UnionFind uf = new UnionFind(n);
        for (int edge[]: edges) {
           if (uf.unionBySize(edge[0], edge[1])) {
            res--;
           }
        }
        return res;
    }

    class UnionFind {
        int parent[];
        int size[];

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        boolean unionBySize(int u, int v) {
            int parU = findUltimatePar(u);
            int parV = findUltimatePar(v);
            if (parU != parV) {
                // Union them, attach smaller to larger. If size equal, it doesn't matter.
                // We can attach any of them to the other one.
                if (size[parU] < size[parV]) {
                    parent[parU] = parV;
                    size[parV] += size[parU];
                } else {
                    parent[parV] = parU;
                    size[parU] += size[parV];
                }
                return true;
            } 
            return false;
        }

        int findUltimatePar(int u) {
            if (parent[u] != u) {
                parent[u] = findUltimatePar(parent[u]);
            }
            return parent[u];
        }
    }
}
