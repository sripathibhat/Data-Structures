class Solution {
    public int largestIsland(int[][] grid) {
        int gridId = 2;
        // Map of gridId and size of the area
        // Sample input grid
        // 1 1 0
        // 1 0 0
        // 1 1 0

        // Grid after transformation
        // 2 2 0
        // 2 0 0
        // 2 2 0
        // Map contents
        // map {{0, 0}, {2, 5}}
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    map.put(gridId, dfs(grid, i, j, gridId));
                    gridId++;
                }
            }
        }
        
        int res = map.getOrDefault(2, 0);
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    if(i > 0) {
                        set.add(grid[i - 1][j]);
                    }
                    if(i < grid.length - 1) {
                        set.add(grid[i + 1][j]);
                    }
                    if(j > 0) {
                        set.add(grid[i][j - 1]);
                    }
                    if(j < grid[i].length - 1) {
                        set.add(grid[i][j + 1]);
                    }
                    int total = 1;
                    for(int id: set) {
                        total += map.get(id);
                    }
                    res = Math.max(res, total);
                }
            }
        }
        return res;
    }
    
    int dfs(int grid[][], int i, int j, int id) {
        if(i < 0 || j < 0 || i > grid.length - 1 || j > grid[i].length - 1 || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = id;
        // traverse all 4 neighbours
        return 1 + dfs(grid, i - 1, j, id) + dfs(grid, i + 1, j, id) + 
                   dfs(grid, i, j - 1, id) + dfs(grid, i, j + 1, id);
    }
}