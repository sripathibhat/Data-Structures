/*

    Tic-tac-toe is played by two players A and B on a 3 x 3 grid.

    Here are the rules of Tic-Tac-Toe:

    Players take turns placing characters into empty squares (" ").
    The first player A always places "X" characters, while the second player B always places "O" characters.
    "X" and "O" characters are always placed into empty squares, never on filled ones.
    The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.
    The game also ends if all squares are non-empty.
    No more moves can be played if the game is over.
    Given an array moves where each element is another array of size 2 corresponding to the row and column of the grid where they
    mark their respective character in the order in which A and B play.

    Return the winner of the game if it exists (A or B), in case the game ends in a draw return "Draw", if there are still movements to play
    return "Pending".

    You can assume that moves is valid (It follows the rules of Tic-Tac-Toe), the grid is initially empty and A will play first.

*/

class Solution {
    public String tictactoe(int[][] moves) {
        char board[][] = new char[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = '.';
            }
        }
        for(int i = 0; i < moves.length; i++) {
            if(i % 2 == 0) {
                // A's move
                board[moves[i][0]][moves[i][1]] = 'X';
            } else {
                // B's move
                board[moves[i][0]][moves[i][1]] = 'O';
            }
        }
        
        String res = checkStatus(board);
        return res;
    }
    
    private String checkStatus(char board[][]) {
        String res = "Draw";
        // check all rows
        for(int i = 0; i < 3; i++) {
            int ca = 0;
            int cb = 0;
            for(int j = 0; j < 3; j++) {
                if(board[i][j] == 'X') {
                    ca++;
                } else if(board[i][j] == 'O') {
                    cb++;
                }
            }
            if(ca == 3) {
                return "A";
            }
            if(cb == 3) {
                return "B";
            }
        }
        
        // check all columns
        for(int j = 0; j < 3; j++) {
            int ca = 0;
            int cb = 0;
            for(int i = 0; i < 3; i++) {
                if(board[i][j] == 'X') {
                    ca++;
                } else if(board[i][j] == 'O') {
                    cb++;
                }
            }
            if(ca == 3) {
                return "A";
            }
            if(cb == 3) {
                return "B";
            }
        }
        
        // check diagonal
        if(board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') return "A";
        if(board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') return "B";
        
        // check anti-diagnoal
        if(board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X') return "A";
        if(board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O') return "B";
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i][j] == '.') {
                    return "Pending";
                }
            }
        }
        return res;
    }
}