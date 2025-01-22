/*

You are given an integer matrix isWater of size m x n that represents a map of land and water cells.

If isWater[i][j] == 0, cell (i, j) is a land cell.
If isWater[i][j] == 1, cell (i, j) is a water cell.
You must assign each cell a height in a way that follows these rules:

The height of each cell must be non-negative.
If the cell is a water cell, its height must be 0.
Any two adjacent cells must have an absolute height difference of at most 1. A cell is adjacent to another cell if the former is directly north, east, south, or west of the latter (i.e., their sides are touching).
Find an assignment of heights such that the maximum height in the matrix is maximized.

Return an integer matrix height of size m x n where height[i][j] is cell (i, j)'s height. If there are multiple solutions, return any of them.

Example 1:

Input: isWater = [[0,1],[0,0]]
Output: [[1,0],[2,1]]
Explanation: The image shows the assigned heights of each cell.
The blue cell is the water cell, and the green cells are the land cells.
Example 2:

Input: isWater = [[0,0,1],[1,0,0],[0,0,0]]
Output: [[1,1,0],[0,1,1],[1,2,2]]
Explanation: A height of 2 is the maximum possible height of any assignment.
Any height assignment that has a maximum height of 2 while still meeting the rules will also be accepted.

*/

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int dirs[][] = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<int[]> queue = new LinkedList<>();
        int m = isWater.length;
        int n = isWater[0].length;
        int heights[][] = new int[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (isWater[row][col] == 1) {
                    queue.add(new int[] {row, col});
                }
            }
        }

        while (!queue.isEmpty()) {
            int arr[] = queue.poll();
            int row = arr[0];
            int col = arr[1];
            for (int i = 0; i < dirs.length; i++) {
                int adjRow = row + dirs[i][0];
                int adjCol = col + dirs[i][1];
                if (adjRow >= 0 && adjCol >= 0 && adjRow < m && adjCol < n && isWater[adjRow][adjCol] == 0) {
                    heights[adjRow][adjCol] = heights[row][col] + 1;
                    isWater[adjRow][adjCol] = 1;
                    queue.add(new int[] {adjRow, adjCol});
                }
            }
        }
        return heights;
    }
}
