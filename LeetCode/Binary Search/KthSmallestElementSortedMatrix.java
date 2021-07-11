class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length - 1;
        int low = matrix[0][0];
        int high = matrix[n][n];
        
        while(low < high) {
            int mid = low + (high - low) / 2;
            int cnt = lessEqual(matrix, mid);
            if(cnt < k) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return low;
    }
    
    private int lessEqual(int matrix[][], int target) {
        int i = matrix.length - 1;
        int j = 0;
        int cnt = 0;
        while(i >= 0 && j < matrix.length) {
            if(matrix[i][j] > target) {
                i--;
            }
            else {
                cnt = cnt + i + 1;
                j++;
            }
        }
        return cnt;
        
    }
}