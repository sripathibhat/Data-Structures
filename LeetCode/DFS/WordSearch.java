/*

    Given an m x n grid of characters board and a string word, return true if word exists in the grid.

    The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally
    or vertically neighboring. The same letter cell may not be used more than once.

*/

class Solution {
    public boolean exist(char[][] board, String word) {
        boolean visited[][] = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(word.charAt(0) == board[i][j] && dfs(board, i, j, 0, word, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, int i, int j, int index, String word, boolean visited[][]) {
        if(index == word.length()) {
            return true;
        }
        if(i < 0 || j < 0 || i >= board.length || j >= board[i].length || word.charAt(index) != board[i][j] ||
            visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if(dfs(board, i + 1, j, index + 1, word, visited) || dfs(board, i - 1, j, index + 1, word, visited) ||
           dfs(board, i, j + 1, index + 1, word, visited) || dfs(board, i, j - 1, index + 1, word, visited)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}