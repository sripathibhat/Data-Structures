/**
  
You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections.
The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.

You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes
timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.

Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.


Example 1:


Input: n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
Output: 4
Explanation: The shortest amount of time it takes to go from intersection 0 to intersection 6 is 7 minutes.
The four ways to get there in 7 minutes are:
- 0 ➝ 6
- 0 ➝ 4 ➝ 6
- 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
- 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6
Example 2:

Input: n = 2, roads = [[1,0,10]]
Output: 1
Explanation: There is only one way to go from intersection 0 to intersection 1, and it takes 10 minutes.

*/

class Solution {
    public int countPaths(int n, int[][] roads) {
        // Build adjacency list
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int t = roads[i][2];
            adjList.get(u).add(new Pair(t, v));
            adjList.get(v).add(new Pair(t, u));
        }
        long dist[] = new long[n];
        int ways[] = new int[n];
        for (int i = 1; i < n; i++) {
            dist[i] = Long.MAX_VALUE;
        }
        ways[0] = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> Long.compare(a.dist, b.dist));
        int MOD = 1000000007;
        pq.add(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            long nodeDist = pair.dist;
            int node = pair.node;
            for (Pair neigh: adjList.get(node)) {
                long neighDist = neigh.dist;
                int neighNode = neigh.node;
                if (dist[neighNode] > nodeDist + neighDist) {
                    pq.add(new Pair(nodeDist + neighDist, neighNode));
                    ways[neighNode] = ways[node];
                    dist[neighNode] = nodeDist + neighDist;
                } else if (dist[neighNode] == nodeDist + neighDist) {
                    ways[neighNode] = (ways[neighNode] + ways[node]) % MOD;
                }
            }
        }
        return ways[n - 1];
    }

    class Pair {
        long dist;
        int node;
        Pair(long d, int n) {
            dist = d;
            node = n;
        }
    }
}
