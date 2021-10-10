/*

    Given an m x n board of characters and a list of strings words, return all words on the board.

    Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally
    or vertically neighboring. The same letter cell may not be used more than once in a word.

*/
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for(String word: words) {
            if(exist(board, word)) {
                res.add(word);
            }
        }
        return res;
    }
    
    private boolean exist(char[][] board, String word) {
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



// Efficient solution - Trie + DFS
// Create a trie for all given words, then do DFS iff trie contains the character which we are currently iterating over the grid.
// Reference - Coding decoded github
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        int m = board.length, n = board[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == ';' || p.children[c - 'a'] == null) return;
        p = p.children[c - 'a'];
        if (p.word != null) {
            res.add(p.word);
            p.word = null;     // de-duplicate
        }

        board[i][j] = ';';
        if (i > 0) dfs(board, i - 1, j ,p, res);
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
        board[i][j] = c;
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words) {
            TrieNode p = root;
            for(char c : word.toCharArray()) {
                int i = c - 'a';
                if (p.children[i] == null) {
                    p.children[i] = new TrieNode();
                }
                p = p.children[i];
            }
            p.word = word;
        }
        return root;
    }
}

class TrieNode {
    String word;
    TrieNode children[];

    TrieNode() {
        children = new TrieNode[26];
    }
}