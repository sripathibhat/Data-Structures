class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        // DFS
        // Iterate over the edges and add them to the graph iff the edge[1] cannot be visited directly/indirectly from edge[0]
        // if edge[1] can be reached from edge[0] already without even adding this edge, then it indicates that there is already a path to reach
        // edge[1] from edge[0], so discard the current edge - it is redundant
        Set<Integer> visited = new HashSet<>();
        List<Integer> graph[] = new ArrayList[1001];
        for(int i = 0; i < 1001; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int edge[]: edges) {
            visited.clear();
            if(!graph[edge[0]].isEmpty() && !graph[edge[1]].isEmpty() && dfs(visited, graph, edge[0], edge[1])) {
                return edge;
            }
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        return new int[] {-1, -1};
        
    }
    
    private boolean dfs(Set<Integer> visited, List<Integer> graph[], int src, int dest) {
        if(visited.contains(src)) {
            return false;
        }
        if(src == dest) {
            return true;
        }
        visited.add(src);
        for(int nei: graph[src]) {
        
            if(dfs(visited, graph, nei, dest)) {
                return true;
            }
        }
        return false;
    }

}