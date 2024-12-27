/**

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]


*/

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // DFS approach
        // Graph g = new Graph(numCourses);
        // for(int i = 0; i < prerequisites.length; i++) {
        // g.addEdge(prerequisites[i][1], prerequisites[i][0]);
        // }
        // // Queue<Integer> q = new LinkedList();
        // Stack<Integer> stack = new Stack();
        // if (g.hasCycle(stack)) {
        // return new int[] {};
        // }
        // int i = 0; // numCourses-1;
        // int res[] = new int[numCourses];
        // while (!stack.isEmpty()) {
        // res[i++] = stack.pop();
        // }
        // return res;

        // BFS approach - Kahn's algorithm
        List<Integer> adj[] = new ArrayList[numCourses];
        int indegree[] = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int res[] = new int[numCourses];
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int i = 0;
        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            res[i++] = node;
            count++;
            for (int x : adj[node]) {
                indegree[x]--;
                if (indegree[x] == 0) {
                    q.add(x);
                }
            }
        }
        if (count == numCourses) {
            return res;
        }
        return new int[] {};

    }
}

class Graph {
    private int v;
    private List<List<Integer>> adj;

    Graph(int vertices) {
        v = vertices;
        adj = new ArrayList();
        for (int i = 0; i < v; i++) {
            adj.add(new LinkedList());
        }
    }

    public void addEdge(int src, int dest) {
        adj.get(src).add(dest);
    }

    public boolean hasCycle(Stack<Integer> stack) {
        boolean visited[] = new boolean[v];
        boolean rec[] = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (hasCycleUtil(i, visited, rec, stack)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycleUtil(int v, boolean visited[], boolean rec[], Stack<Integer> stack) {
        if (rec[v]) {
            return true;
        }
        if (visited[v]) {
            return false;
        }
        rec[v] = true;
        visited[v] = true;
        for (int i : adj.get(v)) {
            if (hasCycleUtil(i, visited, rec, stack)) {
                return true;
            }
        }
        rec[v] = false;
        // q.offer(v);
        stack.push(v);
        return false;
    }
}
