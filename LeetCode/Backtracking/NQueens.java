/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
*/

class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> board = new ArrayList();
        for(int i=0; i<n; i++) {
            List<String> l = new ArrayList();
            for(int j=0; j<n; j++) {
                l.add(".");
            }
            board.add(l);
        }
        solve(board, 0, n);
        return res;
    }
    
    private void solve(List<List<String>> board, int col, int n) {
        if(col == n) {
            List<String> l = new ArrayList();
            for(int i=0; i<n; i++) {
                String x = "";
                for(int j=0; j<n; j++) {
                    x += board.get(i).get(j);
                }
                l.add(x);
            }
            res.add(l);
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