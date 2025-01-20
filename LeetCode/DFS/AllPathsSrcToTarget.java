/*

Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.

The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).

Example 1:

Input: graph = [[1,2],[3],[3],[]]
Output: [[0,1,3],[0,2,3]]
Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.

Example 2:

Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]

*/

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        // BFS approach
        // Queue<List<Integer>> q = new LinkedList<>();
        // q.add(Arrays.asList(0));
        // int goal = graph.length - 1;
        // while (!q.isEmpty()) {
        //     List<Integer> path = q.poll();
        //     int last = path.get(path.size() - 1);
        //     if (last == goal) {
        //         res.add(new ArrayList(path));
        //     } else {
        //         int neigh[] = graph[last];
        //         for (int ne: neigh) {
        //             List<Integer> newPath = new ArrayList(path);
        //             newPath.add(ne);
        //             q.add(newPath);
        //         }
        //     }
        // }

        // DFS efficient
        List<Integer> curPath = new ArrayList<>(Arrays.asList(0));
        dfs(0, graph.length - 1, res, curPath, graph);
        return res;
    }

    private void dfs(int s, int t, List<List<Integer>> res, List<Integer> curPath, int[][] graph) {
        if (s == t) {
            res.add(new ArrayList(curPath)); 
        }
        for (int i = 0; i < graph[s].length; i++) {
            curPath.add(graph[s][i]);
            dfs(graph[s][i], t, res, curPath, graph);
            curPath.remove(curPath.size() - 1);  
        }
    }
}
