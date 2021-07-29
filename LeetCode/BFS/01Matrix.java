class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int dist[][] = new int[mat.length][mat[0].length];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                if(mat[i][j] == 0) {
                    dist[i][j] = 0;
                    q.add(new int[] {i, j});
                }
                else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        int dirs[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int p[] = q.poll();
                for(int j = 0; j < dirs.length; j++) {
                    int nx = p[0] + dirs[j][0];
                    int ny = p[1] + dirs[j][1];
                    if(nx < 0 || ny < 0 || nx >= mat.length || ny >= mat[0].length) {
                        continue;
                    }
                    if(dist[nx][ny] > dist[p[0]][p[1]] + 1) {
                        dist[nx][ny] = dist[p[0]][p[1]] + 1;
                        q.add(new int[] {nx, ny});
                    }
                }
            }
        }
        
        
        return dist;
    }
}