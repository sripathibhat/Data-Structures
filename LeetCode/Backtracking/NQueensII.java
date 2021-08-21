/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.
*/

class Solution {
    int cnt[] = new int[1];
    public int totalNQueens(int n) {
        List<List<String>> board = new ArrayList();
        clearBoard(board, n);
        solve(board, 0, n);
        return cnt[0];
    }
    
    private void clearBoard(List<List<String>> board, int n) {
        for(int i=0; i<n; i++) {
            List<String> l = new ArrayList();
            for(int j=0; j<n; j++) {
                l.add(".");
            }
            board.add(l);
        }
    }
    
    private void solve(List<List<String>> board, int col, int n) {
        if(col == n) {
            cnt[0]++;
            return;
        }
        for(int i=0; i<n; i++) {
            if(isSafe(i, col, board)) {
                board.get(i).set(col, "Q");
                solve(board, col + 1, n);
                board.get(i).set(col, ".");
            }
        }
        
        return;
    }
    
    private boolean isSafe(int row, int col, List<List<String>> board) {
        for(int j=0; j<col; j++) {
            if(board.get(row).get(j) != ".") {
                return false;
            }
        }
        
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if(board.get(i).get(j) != ".") {
                return false;
            }
        }
        
        for(int i=row+1, j=col-1; i<board.size() && j>=0; i++, j--) {
            if(board.get(i).get(j) != ".") {
                return false;
            }
        }
        
        return true;
    }
}