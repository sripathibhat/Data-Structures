class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    private boolean solve(char board[][]) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    for(char c = '1'; c <= '9'; c++) {
                        if(isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if(solve(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValid(char board[][], int row, int col, char c) {
        int nr = 3 * (row / 3); // normalized row - 0 0, 0 3, 0 6, 3 0, 3 3, 3 6, 6 0, 6 3, 6 6
        int nc = 3 * (col / 3); // normalized col
        for(int i = 0; i < 9; i++) {
            if(board[i][col] == c || board[row][i] == c || board[nr + i / 3][nc + i % 3] == c) {
                return false;
            }
        }
        return true;
    }
}