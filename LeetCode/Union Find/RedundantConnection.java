class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        // Union Find
        int n = edges.length + 1;
        int parent[] = new int[n];
        Arrays.fill(parent, -1);
        for(int edge[]: edges) {
            int x = find(parent, edge[0]);
            int y = find(parent, edge[1]);
            if(x == y) {
                return edge;
            }
            union(parent, x, y);
        }
        return new int[] {-1, -1};
    }
    
    private void union(int parent[], int x, int y) {
        parent[x] = y;
    }
    
    private int find(int parent[], int i) {
        if(parent[i] == -1) {
            return i;
        }
        return find(parent, parent[i]);
    }

}