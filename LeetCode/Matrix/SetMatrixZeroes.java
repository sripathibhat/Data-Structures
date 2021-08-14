/*
    Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.
    You must do it in place.
*/
class Solution {
    public void setZeroes(int[][] matrix) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> colns = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    colns.add(j);
                }
            }
        }
        for(int i: rows) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }
        for(int j: colns) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][j] = 0;
            }
        }
    }
}