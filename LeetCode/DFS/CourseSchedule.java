/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites
where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.
*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph g = new Graph(numCourses);
        for(int i = 0; i < prerequisites.length; i++) {
            g.addEdge(prerequisites[i][0], prerequisites[i][1]);
        }
        return !g.hasCycle();
    }
}

class Graph {
    private int v;
    private List<List<Integer>> adj;
    
    Graph(int vertices) {
        v = vertices;
        adj = new ArrayList();
        for(int i = 0; i < v; i++) {
            adj.add(new LinkedList());
        }
    }
    
    public void addEdge(int src, int dest) {
        adj.get(src).add(dest);
    }
    
    public boolean hasCycle() {
        boolean visited[] = new boolean[v];
        boolean rec[] = new boolean[v];
        
        for(int i = 0; i < v; i++) {
            if(hasCycleUtil(i, visited, rec)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean hasCycleUtil(int v, boolean visited[], boolean rec[]) {
        if(rec[v]) {
            return true;
        }
        if(visited[v]) {
            return false;
        }
        rec[v] = true;
        visited[v] = true;
        for(int i: adj.get(v)) {
            if(hasCycleUtil(i, visited, rec)) {
                return true;
            }
        }
        rec[v] = false;
        return false;
    }
}