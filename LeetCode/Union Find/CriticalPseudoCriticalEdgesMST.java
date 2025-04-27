/**

Given a weighted undirected connected graph with n vertices numbered from 0 to n - 1, and an array edges where edges[i] = [ai, bi, weighti] 
represents a bidirectional and weighted edge between nodes ai and bi. A minimum spanning tree (MST) is a subset of the graph's edges that 
connects all vertices without cycles and with the minimum possible total edge weight.

Find all the critical and pseudo-critical edges in the given graph's minimum spanning tree (MST). An MST edge whose deletion from the graph
would cause the MST weight to increase is called a critical edge. On the other hand, a pseudo-critical edge is that which can appear in some MSTs but not all.

Note that you can return the indices of the edges in any order.


Example 1:

Input: n = 5, edges = [[0,1,1],[1,2,1],[2,3,2],[0,3,2],[0,4,3],[3,4,3],[1,4,6]]
Output: [[0,1],[2,3,4,5]]
Explanation: The figure above describes the graph.
The following figure shows all the possible MSTs:

Notice that the two edges 0 and 1 appear in all MSTs, therefore they are critical edges, so we return them in the first list of the output.
The edges 2, 3, 4, and 5 are only part of some MSTs, therefore they are considered pseudo-critical edges. We add them to the second list of the output.


Example 2:

Input: n = 4, edges = [[0,1,1],[1,2,1],[2,3,1],[0,3,1]]
Output: [[],[0,1,2,3]]
Explanation: We can observe that since all 4 edges have equal weight, choosing any 3 edges from the given 4 will yield an MST. Therefore all 4 edges are pseudo-critical.

*/

public class Solution {
    
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<int[]> edgeList = new ArrayList();
        for (int i = 0; i < edges.length; i++) {
            edgeList.add(new int[] { edges[i][0], edges[i][1], edges[i][2], i });
        }

        Collections.sort(edgeList, (a, b) -> a[2] - b[2]);
        int mstWeight = 0;
        UnionFind uf = new UnionFind(n);
        for (int edge[]: edgeList) {
            if (uf.union(edge[0], edge[1])) {
                mstWeight += edge[2];
            }
        }

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();

        for (int edge[]: edgeList) {
            // Try without current edge
            UnionFind ufWithout = new UnionFind(n);
            int wt = 0;
            for (int e[]: edgeList) {
                if (e[3] != edge[3] && ufWithout.union(e[0], e[1])) {
                    wt += e[2];
                }
            }
            if (Arrays.stream(ufWithout.rank).max().getAsInt() != n || wt > mstWeight) {
                critical.add(edge[3]);
                continue;
            }

            // Try with current edge
            UnionFind ufWith = new UnionFind(n);
            ufWith.union(edge[0], edge[1]);
            wt = edge[2];
            for (int e[]: edgeList) {
                if (ufWith.union(e[0], e[1])) {
                    wt += e[2];
                }
            }
            if (wt == mstWeight) {
                pseudo.add(edge[3]);
            }
        }

        return Arrays.asList(critical, pseudo);
    }
}

class UnionFind {
    int par[];
    int rank[];

    UnionFind(int n) {
        par = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int v) {
        while (par[v] != v) {
            par[v] = par[par[v]];
            v = par[v];
        }
        return par[v];
    }

    public boolean union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 == p2) {
            return false;
        }
        if (rank[p1] > rank[p2]) {
            par[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            par[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }
}
