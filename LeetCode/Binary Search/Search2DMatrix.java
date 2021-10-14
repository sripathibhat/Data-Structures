/*

    Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.
 
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n - 1;
        while(i >= 0 && i < m && j >= 0 && j < n) {
            if(matrix[i][j] == target) {
                return true;
            }
            if(matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}