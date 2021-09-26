/*

    You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle). You can move up, down, left, or right from and
    to an empty cell in one step.

    Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1) given that you
    can eliminate at most k obstacles. If it is not possible to find such walk return -1.

*/

// Maintain a queue to store coordinates visited along with their obstacles along the path.
// obs[x][[y] = curObs + grid[x][y]
// if x,y is not already visited, then add it to q with obstacle obs[x][y]
// if x,y is alread visited but new obstacle is less than prev obstacle, then again add it to queue and update its obstacle

class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        int obstacles[][] = new int[m][n];
        Queue<Cell> q = new LinkedList<>();
        q.add(new Cell(0, 0));
        obstacles[0][0] = grid[0][0];
        int level = 1;
        int dirs[][] = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Cell cell = q.poll();
                int obs = obstacles[cell.x][cell.y];
                if(cell.x == m - 1 && cell.y == n - 1) {
                    return level - 1;
                }
                for(int[] dir: dirs) {
                    int x = cell.x + dir[0];
                    int y = cell.y + dir[1];
                    if(x < 0 || y < 0 || x >= m || y >= n) {
                        continue;
                    }
                    int newObs = obs + grid[x][y];
                    if(!visited[x][y] && newObs <= k) {
                        q.add(new Cell(x, y));
                        obstacles[x][y] = newObs;
                        visited[x][y] = true;
                    }
                    if(visited[x][y] && obstacles[x][y] > newObs) {
                        q.add(new Cell(x, y));
                        obstacles[x][y] = newObs;
                    }
                }
            }
            level++;
        }
        return -1;
    }
    
    
    class Cell {
        int x;
        int y;
        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}