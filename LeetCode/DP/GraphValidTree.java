/**

Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

Example 1:

Input:
n = 5
edges = [[0, 1], [0, 2], [0, 3], [1, 4]]

Output:
true
Example 2:

Input:
n = 5
edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]

Output:
false


Note:

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

*/

class Solution {
    public boolean validTree(int n, int[][] edges) {
        // cycle detection. If cycle exists, it is not a valid tree.
        // A tree will have at max n - 1 edges, if not, it is not a tree.
        // All nodes in a tree will be connected. If there are disconnected components, it is not a tree. It will be a forest.
      
        if (edges.length > n - 1) {
            return false;
        }
        Set<Integer> visit = new HashSet<>();
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int edge[]: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        if (!dfs(0, -1, adjList, visit)) {
            return false;
        }
        
        return visit.size() == n;
    }

    private boolean dfs(int cur, int par, List<List<Integer>> adjList, Set<Integer> visit) {
        if (visit.contains(cur)) {
            return false;
        }
        visit.add(cur);
      
        for (int x: adjList.get(cur)) {
            if (x == par) {
                continue;
            }
            if (!dfs(x, cur, adjList, visit)) {
                return false;
            }
        }
        return true;
    }
}

