/*

    Design an algorithm that accepts a stream of characters and checks if a suffix of these characters
    is a string of a given array of strings words.

    For example, if words = ["abc", "xyz"] and the stream added the four characters (one by one) 'a', 'x', 'y',
    and 'z', your algorithm should detect that the suffix "xyz" of the characters "axyz" matches "xyz" from words.

    Implement the StreamChecker class:

    StreamChecker(String[] words) Initializes the object with the strings array words.
    boolean query(char letter) Accepts a new character from the stream and returns true if any non-empty
    suffix from the stream forms a word that is in words.
*/

class StreamChecker {
    
    TrieNode root;
    StringBuilder sb;
    
    public StreamChecker(String[] words) {
        root = new TrieNode();
        sb = new StringBuilder();
        for(String word: words) {
            addWord(word);
        }
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        return search(sb.toString());
    }
    
    private class TrieNode {
        private TrieNode children[];
        private boolean isWord;
        TrieNode() {
            children = new TrieNode[26];
        }
    }
    
    private void addWord(String word) {
        TrieNode node = root;
        for(int i = word.length() - 1; i >= 0; i--) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if(node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isWord = true;
    }

    private boolean search(String s) {
        TrieNode node = root;
        for(int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            int index = ch - 'a';
            if(node != null && node.children[index] != null) {
                node = node.children[index];
                if(node.isWord) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */