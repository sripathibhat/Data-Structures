// 212
class Solution {
    boolean visited[][];
    public List<String> findWords(char[][] board, String[] words) {
        visited = new boolean[board.length][board[0].length];
        List<String> res = new ArrayList();
        for(String word: words) {
            visited = new boolean[board.length][board[0].length];
            if(exist(word, board)) {
                res.add(word);
            }
        }
        return res;
    }
    
    private boolean exist(String word, char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(word.charAt(0) == board[i][j] && searchWord(i,j,0,word,board)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean searchWord(int i, int j, int index, String word, char[][] board) {
        if(index == word.length()) {
            return true;
        }
        if(i<0 || j<0 || i>=board.length || j>=board[i].length || visited[i][j] || word.charAt(index) != board[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if(searchWord(i+1,j,index+1,word,board) || 
           searchWord(i-1,j,index+1,word,board) ||
           searchWord(i,j+1,index+1,word,board) ||
           searchWord(i,j-1,index+1,word,board)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}